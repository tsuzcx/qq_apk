package com.tencent.mm.plugin.sns.model;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.x;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bfm;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.btw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.ui.widget.QImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class g
  implements com.tencent.mm.plugin.sns.b.f
{
  private static int opm = 0;
  private Map<Integer, WeakReference<Object>> enZ = new HashMap();
  public boolean ooI = true;
  private long ooP = 0L;
  private long ooQ = 0L;
  ab<String, com.tencent.mm.memory.n> ooR;
  private al<String, WeakReference<Bitmap>> ooS;
  private Map<String, LinkedList<WeakReference<g.c>>> ooT = new HashMap();
  private ConcurrentHashMap<Integer, String> ooU = new ConcurrentHashMap();
  private LinkedList<g.b> ooV = new LinkedList();
  private boolean ooW = false;
  private HashSet<g.c> ooX = new HashSet();
  public HashMap<String, Integer> ooY = new HashMap();
  private int ooZ = 4;
  public x opa;
  public long opb = 0L;
  public long opc = 0L;
  private int opd = 0;
  private int ope = 0;
  private HashMap<Long, Integer> opf = new HashMap();
  private HashMap<Integer, Boolean> opg = new HashMap();
  private HashMap<Integer, Boolean> oph = new HashMap();
  private int opi = 0;
  private int opj = 0;
  private HashMap<Long, Integer> opk = new HashMap();
  protected Set<String> opl = new HashSet();
  
  public g()
  {
    int i = ((ActivityManager)ae.getContext().getSystemService("activity")).getLargeMemoryClass();
    y.i("MicroMsg.LazyerImageLoader2", "BitmapPool %dMB", new Object[] { Integer.valueOf(i) });
    if (i > 256) {}
    for (i = 10485760;; i = 5242880)
    {
      this.ooR = new ab(i)
      {
        public final void trimToSize(int paramAnonymousInt)
        {
          try
          {
            super.trimToSize(paramAnonymousInt);
            return;
          }
          catch (Exception localException)
          {
            y.e("MicroMsg.LazyerImageLoader2", "trimToSize error: %s", new Object[] { localException.getMessage() });
          }
        }
      };
      this.ooS = new al(this.ooZ, new al.a()
      {
        public final boolean bB(Object paramAnonymousObject)
        {
          String str = (String)paramAnonymousObject;
          Object localObject;
          if (g.a(g.this, str)) {
            localObject = g.a(g.this);
          }
          for (;;)
          {
            try
            {
              paramAnonymousObject = ((al.b)((al)localObject).otf.get(str)).obj;
              if (!(paramAnonymousObject instanceof Bitmap)) {
                continue;
              }
              paramAnonymousObject = (Bitmap)paramAnonymousObject;
              if ((paramAnonymousObject != null) && (!paramAnonymousObject.isRecycled()))
              {
                y.d("MicroMsg.SnsLRUMap", "remove key:" + str);
                paramAnonymousObject.recycle();
              }
            }
            catch (Exception paramAnonymousObject)
            {
              int i;
              y.printErrStackTrace("MicroMsg.SnsLRUMap", paramAnonymousObject, "", new Object[0]);
              y.e("MicroMsg.SnsLRUMap", "can not recycled forceRemove ");
              continue;
              boolean bool = false;
              continue;
            }
            i = ((al)localObject).otf.size();
            paramAnonymousObject = ((al)localObject).otf.remove(str);
            localObject = new StringBuilder("internalMap ").append(((al)localObject).otf.size()).append(" bfSize :").append(i).append(" o == null ");
            if (paramAnonymousObject != null)
            {
              bool = true;
              y.d("MicroMsg.SnsLRUMap", bool);
              y.i("MicroMsg.LazyerImageLoader2", "keys " + str + " deRef ok  Big:size:" + g.a(g.this).otf.size() + " listPaitSize:" + g.b(g.this).size());
              return true;
              paramAnonymousObject = (WeakReference)((al.b)((al)localObject).otf.get(str)).obj;
              if (paramAnonymousObject != null) {
                paramAnonymousObject = (Bitmap)paramAnonymousObject.get();
              }
            }
            else
            {
              return false;
            }
            paramAnonymousObject = null;
          }
        }
      });
      return;
    }
  }
  
  public static String C(awd paramawd)
  {
    if (paramawd == null) {
      return null;
    }
    if (paramawd.lsK.startsWith("pre_temp_sns_pic")) {
      return af.getAccSnsTmpPath() + paramawd.lsK;
    }
    if (paramawd.lsK.startsWith("Locall_path")) {
      return an.eJ(af.getAccSnsPath(), paramawd.lsK) + i.m(paramawd);
    }
    if (paramawd.lsK.startsWith("pre_temp_extend_pic")) {
      return paramawd.lsK.substring(19);
    }
    return an.eJ(af.getAccSnsPath(), paramawd.lsK) + i.d(paramawd);
  }
  
  private boolean P(View paramView, int paramInt)
  {
    if (paramView.hashCode() == paramInt) {
      return true;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = paramView.getChildCount();
      int j;
      do
      {
        j = i - 1;
        if (j < 0) {
          break;
        }
        i = j;
      } while (!P(paramView.getChildAt(j), paramInt));
      return true;
    }
    return false;
  }
  
  public static Bitmap a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, az paramaz)
  {
    if ((!paramBoolean) && (bk.bl(paramString1))) {
      paramString1 = null;
    }
    do
    {
      awd localawd;
      do
      {
        return paramString1;
        localawd = com.tencent.mm.modelsns.e.a(paramString3, 2, paramString2, paramString2, 1, 1, "");
        i.aG(2, paramString3);
        if (!paramString3.equals("")) {
          break;
        }
        paramString2 = i.MZ(paramString1);
        paramString1 = paramString2;
      } while (i.s(paramString2));
      return null;
      if (i.s(null)) {
        return null;
      }
      Object localObject = i.l(localawd);
      localObject = i.MZ(an.eJ(af.getAccSnsPath(), paramString3) + (String)localObject);
      paramString3 = (String)localObject;
      if (!i.s((Bitmap)localObject)) {
        paramString3 = i.MZ(paramString1);
      }
      if ((paramString3 == null) && (paramBoolean) && (!bk.bl(paramString2))) {
        af.bDA().a(localawd, 3, null, paramaz);
      }
      paramString1 = paramString3;
    } while (i.s(paramString3));
    return null;
  }
  
  private void a(Object paramObject, String paramString, int paramInt1, int paramInt2)
  {
    a(paramObject, paramString, true, paramInt1, paramInt2, -1, -1, g.a.opy);
  }
  
  private void a(Object paramObject, String paramString, int paramInt1, int paramInt2, g.a parama)
  {
    a(paramObject, paramString, true, paramInt1, paramInt2, -1, -1, parama);
  }
  
  private static void a(Object paramObject, String paramString, com.tencent.mm.memory.n paramn)
  {
    long l2 = 0L;
    if (paramObject == null) {
      return;
    }
    if (paramn != null) {
      y.i("MicroMsg.LazyerImageLoader2", "setImageDrawable %s %s %s", new Object[] { paramObject, paramString, paramn.Fh() });
    }
    Object localObject;
    long l1;
    if ((paramObject instanceof QFadeImageView))
    {
      paramObject = (QFadeImageView)paramObject;
      localObject = paramObject.getDrawable();
      l1 = l2;
      if (!bk.bl(paramObject.getImageKey()))
      {
        l1 = l2;
        if (paramObject.getImageKey().equals(paramString)) {
          l1 = paramObject.getStartTimeMillis();
        }
      }
      if ((localObject == null) || (!(localObject instanceof ai))) {
        break label350;
      }
      l1 = ((ai)localObject).kKK;
    }
    label350:
    for (;;)
    {
      paramn = new ai(paramString, paramn, l1);
      paramObject.kKK = paramn.kKK;
      paramObject.key = paramString;
      paramObject.setImageDrawable(paramn);
      paramn.invalidateSelf();
      return;
      if ((paramObject instanceof QDisFadeImageView))
      {
        paramObject = (QDisFadeImageView)paramObject;
        paramString = new com.tencent.mm.memory.a.a(paramString, paramn);
        paramObject.setImageDrawable(paramString);
        paramString.invalidateSelf();
        return;
      }
      if ((paramObject instanceof ImageView))
      {
        localObject = (ImageView)paramObject;
        paramObject = ((ImageView)localObject).getDrawable();
        if ((paramObject != null) && ((paramObject instanceof ai))) {}
        for (paramObject = new ai(paramString, paramn, ((ai)paramObject).kKK);; paramObject = new ai(paramString, paramn, 0L))
        {
          ((ImageView)localObject).setImageDrawable(paramObject);
          paramObject.invalidateSelf();
          return;
        }
      }
      if (!(paramObject instanceof com.tencent.mm.plugin.sight.decode.a.a)) {
        break;
      }
      y.i("MicroMsg.LazyerImageLoader2", "update sight thumb " + paramString);
      if (!(paramObject instanceof SightPlayImageView)) {
        break;
      }
      localObject = (SightPlayImageView)paramObject;
      paramObject = ((SightPlayImageView)localObject).getDrawable();
      if ((paramObject != null) && ((paramObject instanceof ai))) {}
      for (paramObject = new ai(paramString, paramn, ((ai)paramObject).kKK);; paramObject = new ai(paramString, paramn, 0L))
      {
        ((SightPlayImageView)localObject).setImageDrawable(paramObject);
        paramObject.invalidateSelf();
        return;
      }
    }
  }
  
  private void a(Object paramObject, String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, g.a parama)
  {
    if (paramObject == null) {
      return;
    }
    int i = paramObject.hashCode();
    this.ooX.remove(new g.c(null, i, 0, false));
    g.c localc = new g.c(paramString, i, paramInt2, paramBoolean);
    this.ooX.add(localc);
    LinkedList localLinkedList = (LinkedList)this.ooT.get(paramString);
    Object localObject = localLinkedList;
    if (localLinkedList == null)
    {
      localObject = new LinkedList();
      this.ooT.put(paramString, localObject);
    }
    ((LinkedList)localObject).add(new WeakReference(localc));
    localObject = (String)((View)paramObject).getTag(2130706432);
    if (localObject != null)
    {
      localLinkedList = (LinkedList)this.ooT.get(localObject);
      if (localLinkedList != null)
      {
        paramInt2 = 0;
        if (paramInt2 >= localLinkedList.size()) {
          break label469;
        }
        localc = (g.c)((WeakReference)localLinkedList.get(paramInt2)).get();
        if ((localc == null) || (localc.code != i)) {
          break label325;
        }
      }
    }
    for (;;)
    {
      if (paramInt2 != -1)
      {
        y.v("MicroMsg.LazyerImageLoader2", "updateImageViewToKey remove last pair %s", new Object[] { localObject });
        localLinkedList.remove(paramInt2);
      }
      ((View)paramObject).setTag(2130706432, paramString);
      localObject = new WeakReference(paramObject);
      this.enZ.put(Integer.valueOf(i), localObject);
      if (paramInt1 != -1)
      {
        if (!(paramObject instanceof QFadeImageView)) {
          break label334;
        }
        ((QFadeImageView)paramObject).setImageResource(paramInt1);
      }
      for (;;)
      {
        if ((parama == g.a.opz) && (((paramObject instanceof ImageView)) || ((paramObject instanceof QFadeImageView))))
        {
          k.bO((View)paramObject);
          return;
          label325:
          paramInt2 += 1;
          break;
          label334:
          if ((paramObject instanceof ImageView))
          {
            ((ImageView)paramObject).setImageDrawable(com.tencent.mm.cb.a.g(((ImageView)paramObject).getContext(), paramInt1));
          }
          else
          {
            localObject = (com.tencent.mm.plugin.sight.decode.a.a)paramObject;
            if (!this.ooI) {}
            for (paramBoolean = true;; paramBoolean = false)
            {
              ((com.tencent.mm.plugin.sight.decode.a.a)localObject).aW(null, paramBoolean);
              break;
            }
          }
        }
      }
      if ((paramString == null) || (!paramString.startsWith("3")) || ((!(paramObject instanceof ImageView)) && (!(paramObject instanceof QFadeImageView)))) {
        break;
      }
      k.o((View)paramObject, paramInt3, paramInt4);
      y.d("MicroMsg.LazyerImageLoader2", "try to setlayerType " + paramInt3 + " " + paramInt4);
      return;
      label469:
      paramInt2 = -1;
    }
  }
  
  private boolean a(int paramInt, awd paramawd, az paramaz)
  {
    if (!this.ooI) {
      return false;
    }
    af.bDs().post(new g.7(this, paramInt, paramawd, paramaz));
    return true;
  }
  
  public static boolean a(awd paramawd, az paramaz, boolean paramBoolean)
  {
    if ((paramawd == null) || (paramawd.lsK == null) || (paramawd.lsK.equals(""))) {
      return false;
    }
    Object localObject;
    if (paramawd.lsK.startsWith("Locall_path"))
    {
      localObject = an.eJ(af.getAccSnsPath(), paramawd.lsK) + i.m(paramawd);
      if (com.tencent.mm.vfs.e.bK((String)localObject)) {
        break label142;
      }
      localObject = af.bDA();
      if (!paramBoolean) {
        break label137;
      }
    }
    label137:
    for (int i = 8;; i = 2)
    {
      ((b)localObject).a(paramawd, i, null, paramaz);
      return false;
      localObject = an.eJ(af.getAccSnsPath(), paramawd.lsK) + i.d(paramawd);
      break;
    }
    label142:
    return true;
  }
  
  private boolean a(String paramString, com.tencent.mm.memory.n paramn)
  {
    if ((paramn != null) && (paramString != null)) {
      this.ooR.put(paramString, paramn);
    }
    return true;
  }
  
  private boolean bCV()
  {
    if (this.ooW)
    {
      y.i("MicroMsg.LazyerImageLoader2", "loaderlist size runing pass");
      return false;
    }
    af.aXq().postDelayed(new Runnable()
    {
      public final void run()
      {
        if (g.d(g.this)) {
          y.i("MicroMsg.LazyerImageLoader2", "loaderlist size runing pass");
        }
        while (g.e(g.this).size() <= 0) {
          return;
        }
        y.i("MicroMsg.LazyerImageLoader2", "tryStart loaderlist size:" + g.e(g.this).size());
        ((g.b)g.e(g.this).removeLast()).p(new String[] { "" });
      }
    }, 0L);
    return true;
  }
  
  private static void cN(View paramView)
  {
    if ((paramView instanceof QImageView)) {
      ((QImageView)paramView).setImageResource(i.e.friendactivity_comment_detail_list2);
    }
    while (!(paramView instanceof ImageView)) {
      return;
    }
    ((ImageView)paramView).setImageResource(i.e.friendactivity_comment_detail_list2);
  }
  
  private static boolean cn(String paramString, int paramInt)
  {
    paramString = bn.s(paramString, "SightDownloadControl");
    if ((paramString == null) || (paramString.isEmpty())) {
      return true;
    }
    if (paramInt == 1) {
      return bk.getInt((String)paramString.get(".SightDownloadControl.G3PlusAutoDownload"), 0) == 1;
    }
    return bk.getInt((String)paramString.get(".SightDownloadControl.WifiAutoDownload"), 0) == 1;
  }
  
  public static String r(awd paramawd)
  {
    Object localObject;
    if ((paramawd == null) || (paramawd.lsK == null) || (paramawd.lsK.equals(""))) {
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      str = an.eJ(af.getAccSnsPath(), paramawd.lsK) + i.e(paramawd);
      localObject = str;
    } while (com.tencent.mm.vfs.e.bK(str));
    return paramawd.trP;
  }
  
  public static String s(awd paramawd)
  {
    Object localObject;
    if ((paramawd == null) || (paramawd.lsK == null) || (paramawd.lsK.equals(""))) {
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      str = an.eJ(af.getAccSnsPath(), paramawd.lsK) + i.d(paramawd);
      localObject = str;
    } while (com.tencent.mm.vfs.e.bK(str));
    return paramawd.kSC;
  }
  
  public static boolean t(awd paramawd)
  {
    String str1 = an.eJ(af.getAccSnsPath(), paramawd.lsK);
    String str2 = i.j(paramawd);
    if (com.tencent.mm.vfs.e.bK(str1 + str2)) {}
    while ((com.tencent.mm.vfs.e.bK(str1 + i.p(paramawd))) && (!bk.bl(paramawd.lsK)) && (paramawd.lsK.startsWith("Locall_path"))) {
      return true;
    }
    return false;
  }
  
  public final void A(awd paramawd)
  {
    this.ooY.put(paramawd.lsK, Integer.valueOf(3));
  }
  
  public final boolean B(awd paramawd)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramawd == null) || (paramawd.lsK == null) || (paramawd.lsK.equals(""))) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (com.tencent.mm.vfs.e.bK(an.eJ(af.getAccSnsPath(), paramawd.lsK) + i.f(paramawd)));
      bool1 = bool2;
    } while (com.tencent.mm.vfs.e.bK(an.eJ(af.getAccSnsPath(), paramawd.lsK) + i.e(paramawd)));
    paramawd = i.aG(1, paramawd.lsK);
    return i.b((com.tencent.mm.memory.n)this.ooR.get(paramawd));
  }
  
  public final void M(Activity paramActivity)
  {
    y.d("MicroMsg.LazyerImageLoader2", "try to remove ImageView " + this.enZ.size());
    Object localObject1 = new LinkedList();
    Object localObject2 = this.ooX.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (g.c)((Iterator)localObject2).next();
      if (P(paramActivity.getWindow().getDecorView(), ((g.c)localObject3).code)) {
        ((List)localObject1).add(Integer.valueOf(((g.c)localObject3).code));
      }
    }
    localObject2 = ((List)localObject1).iterator();
    int i;
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label205;
      }
      i = ((Integer)((Iterator)localObject2).next()).intValue();
      this.enZ.remove(Integer.valueOf(i));
      localObject3 = this.ooX.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        g.c localc = (g.c)((Iterator)localObject3).next();
        if (localc.code != i) {
          break;
        }
        this.ooX.remove(localc);
      }
    }
    label205:
    ((List)localObject1).clear();
    localObject2 = this.ooX.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (g.c)((Iterator)localObject2).next();
      if (((g.c)localObject3).opC == paramActivity.hashCode()) {
        ((List)localObject1).add(Integer.valueOf(((g.c)localObject3).code));
      }
    }
    paramActivity = ((List)localObject1).iterator();
    for (;;)
    {
      if (!paramActivity.hasNext()) {
        break label365;
      }
      i = ((Integer)paramActivity.next()).intValue();
      this.enZ.remove(Integer.valueOf(i));
      localObject1 = this.ooX.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (g.c)((Iterator)localObject1).next();
        if (((g.c)localObject2).code != i) {
          break;
        }
        this.ooX.remove(localObject2);
      }
    }
    label365:
    this.ooS.bEb();
    y.d("MicroMsg.LazyerImageLoader2", "after try to remove ImageView " + this.enZ.size());
  }
  
  public final com.tencent.mm.memory.n Nr(String paramString)
  {
    com.tencent.mm.memory.n localn2 = (com.tencent.mm.memory.n)this.ooR.get(paramString);
    com.tencent.mm.memory.n localn1;
    if (localn2 != null)
    {
      localn1 = localn2;
      if (!localn2.isRecycled()) {}
    }
    else
    {
      this.ooR.remove(paramString);
      localn1 = null;
    }
    return localn1;
  }
  
  public final void Ns(String paramString)
  {
    b(paramString, null);
  }
  
  public final com.tencent.mm.memory.n Nt(String paramString)
  {
    if (this.ooR == null) {
      return null;
    }
    return (com.tencent.mm.memory.n)this.ooR.get("0-" + paramString);
  }
  
  public final int a(com.tencent.mm.plugin.sns.storage.n paramn, int[] paramArrayOfInt)
  {
    int j = 5;
    Object localObject;
    PInt localPInt1;
    PInt localPInt2;
    if ((paramArrayOfInt != null) || (bk.cp(this.opb) > 60000L))
    {
      localObject = new PInt();
      localPInt1 = new PInt();
      localPInt2 = new PInt();
      com.tencent.mm.modelcontrol.c.Ni();
      if (!com.tencent.mm.modelcontrol.c.a((PInt)localObject, localPInt1, localPInt2)) {
        break label135;
      }
      this.opd = 5;
      if (paramArrayOfInt != null) {
        if (((PInt)localObject).value != 0) {
          break label144;
        }
      }
    }
    label135:
    label144:
    for (int i = 0;; i = 1)
    {
      paramArrayOfInt[0] = i;
      paramArrayOfInt[1] = localPInt1.value;
      paramArrayOfInt[2] = localPInt2.value;
      this.ope = ((PInt)localObject).value;
      this.opb = bk.UZ();
      if ((this.ope != 0) && (paramn != null)) {
        break label149;
      }
      return this.opd;
      this.opd = 10;
      break;
    }
    label149:
    if (this.opf.containsKey(Long.valueOf(paramn.field_snsId))) {
      return ((Integer)this.opf.get(Long.valueOf(paramn.field_snsId))).intValue();
    }
    paramArrayOfInt = new btw();
    try
    {
      localObject = (bto)new bto().aH(paramn.field_attrBuf);
      if (((bto)localObject).tKl == null) {
        return this.opd;
      }
      paramArrayOfInt.aH(((bto)localObject).tKl.tFM.oY);
      if ((paramArrayOfInt.tKA == null) || (paramArrayOfInt.tKA.info == null))
      {
        i = this.opd;
        return i;
      }
    }
    catch (Exception paramn)
    {
      y.printErrStackTrace("MicroMsg.LazyerImageLoader2", paramn, "", new Object[0]);
      return this.opd;
    }
    paramArrayOfInt = paramArrayOfInt.tKA.info;
    i = paramArrayOfInt.hashCode();
    if (this.ope == 1)
    {
      if (!this.oph.containsKey(Integer.valueOf(i))) {
        this.oph.put(Integer.valueOf(i), Boolean.valueOf(cn(paramArrayOfInt, this.ope)));
      }
      if (((Boolean)this.oph.get(Integer.valueOf(i))).booleanValue()) {}
      for (i = 5;; i = 10)
      {
        y.i("MicroMsg.LazyerImageLoader2", "isAutoDownload(sight_autodownload) snsID:%d, result:%d", new Object[] { Long.valueOf(paramn.field_snsId), Integer.valueOf(i) });
        this.opf.put(Long.valueOf(paramn.field_snsId), Integer.valueOf(i));
        return i;
      }
    }
    if (!this.opg.containsKey(Integer.valueOf(i))) {
      this.opg.put(Integer.valueOf(i), Boolean.valueOf(cn(paramArrayOfInt, this.ope)));
    }
    if (((Boolean)this.opg.get(Integer.valueOf(i))).booleanValue()) {}
    for (i = j;; i = 10) {
      break;
    }
  }
  
  public final Bitmap a(awd paramawd, View paramView, int paramInt, az paramaz, boolean paramBoolean)
  {
    return a(paramawd, paramView, paramInt, true, paramaz, paramBoolean);
  }
  
  public final Bitmap a(awd paramawd, View paramView, int paramInt, boolean paramBoolean1, az paramaz, boolean paramBoolean2)
  {
    Object localObject1;
    if ((paramawd == null) || (paramawd.lsK == null) || (paramawd.lsK.equals(""))) {
      localObject1 = null;
    }
    String str;
    Object localObject2;
    label93:
    do
    {
      return localObject1;
      str = i.aG(3, paramawd.lsK);
      localObject2 = C(paramawd);
      int j = -1;
      int k = -1;
      int i = j;
      try
      {
        localObject1 = com.tencent.mm.sdk.platformtools.c.YU((String)localObject2);
        i = j;
        j = ((BitmapFactory.Options)localObject1).outWidth;
        i = j;
        int m = ((BitmapFactory.Options)localObject1).outHeight;
        k = m;
        i = j;
      }
      catch (Exception localException)
      {
        boolean bool;
        break label93;
      }
      a(paramView, str, false, -1, paramInt, i, k, g.a.opy);
      if (af.bDA().Nn(paramawd.lsK)) {
        return null;
      }
      paramView = this.ooS;
      localObject1 = (al.b)paramView.otf.get(str);
      if (localObject1 != null) {
        break;
      }
      paramView = null;
      paramView = (WeakReference)paramView;
      localObject1 = new StringBuilder("getFromWeakReference ").append(str).append("  ");
      if (paramView != null) {
        break label339;
      }
      bool = true;
      y.i("MicroMsg.LazyerImageLoader2", bool);
      if (paramView != null) {
        break label345;
      }
      paramView = null;
      localObject1 = paramView;
    } while (i.s(paramView));
    label188:
    label209:
    if (paramawd.lsK.startsWith("pre_temp_extend_pic"))
    {
      paramView = s.OS((String)localObject2);
      label237:
      localObject1 = this.ooS;
      localObject2 = new WeakReference(paramView);
      if ((al.b)((al)localObject1).otf.get(str) != null) {
        break label365;
      }
      localObject2 = new al.b((al)localObject1, localObject2);
      ((al)localObject1).otf.put(str, localObject2);
      ((al)localObject1).bEb();
    }
    for (;;)
    {
      if (!i.s(paramView)) {
        break label406;
      }
      return paramView;
      ((al.b)paramView.otf.get(str)).bEc();
      paramView = ((al.b)localObject1).obj;
      break;
      label339:
      bool = false;
      break label188;
      label345:
      paramView = (Bitmap)paramView.get();
      break label209;
      paramView = i.MZ((String)localObject2);
      break label237;
      label365:
      ((al.b)((al)localObject1).otf.get(str)).bEc();
      ((al.b)((al)localObject1).otf.get(str)).obj = localObject2;
    }
    label406:
    if (paramBoolean1)
    {
      paramView = af.bDA();
      if (!paramBoolean2) {
        break label435;
      }
    }
    label435:
    for (paramInt = 8;; paramInt = 2)
    {
      paramView.a(paramawd, paramInt, null, paramaz);
      return null;
    }
  }
  
  public final com.tencent.mm.memory.n a(awd paramawd, ImageView paramImageView, int paramInt, az paramaz)
  {
    if ((paramawd == null) || (paramawd.lsK == null) || (paramawd.lsK.equals(""))) {
      return null;
    }
    paramImageView.setDrawingCacheEnabled(false);
    String str = i.aG(0, paramawd.lsK);
    a(paramImageView, str, -1, paramInt);
    paramImageView = paramawd.lsK;
    paramImageView = Nr(str);
    if (!i.b(paramImageView))
    {
      a(0, paramawd, paramaz);
      return null;
    }
    return paramImageView;
  }
  
  public final String a(awd paramawd)
  {
    String str = an.eJ(af.getAccSnsPath(), paramawd.lsK);
    paramawd = i.e(paramawd);
    return str + paramawd;
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramView, null, true, -1, paramInt3, -1, -1, g.a.opy);
    if (paramInt1 != -1) {
      paramView.setBackgroundResource(paramInt1);
    }
    if (paramInt2 != -1) {
      if ((paramView instanceof QFadeImageView)) {
        ((QFadeImageView)paramView).setImageResource(paramInt2);
      }
    }
    do
    {
      do
      {
        return;
      } while (!(paramView instanceof ImageView));
      ((ImageView)paramView).setImageDrawable(com.tencent.mm.cb.a.g(paramView.getContext(), paramInt2));
      return;
      if ((paramView instanceof QFadeImageView))
      {
        ((QFadeImageView)paramView).setImageResource(i.e.friendactivity_comment_detail_list2);
        return;
      }
    } while (!(paramView instanceof ImageView));
    ((ImageView)paramView).setImageResource(i.e.friendactivity_comment_detail_list2);
  }
  
  public final void a(awd paramawd, View paramView, int paramInt1, int paramInt2, g.a parama, az paramaz)
  {
    if ((paramawd == null) || (paramawd.lsK == null) || (paramawd.lsK.equals(""))) {}
    String str;
    do
    {
      return;
      paramView.setDrawingCacheEnabled(false);
      str = i.aG(0, paramawd.lsK);
      a(paramView, str, paramInt1, paramInt2, parama);
      parama = paramawd.lsK;
      parama = Nr(str);
      if (i.b(parama)) {
        break;
      }
      if (paramInt1 == -1) {
        cN(paramView);
      }
    } while (this.opl.contains(str));
    a(0, paramawd, paramaz);
    return;
    a(paramView, str, parama);
  }
  
  public final void a(awd paramawd, View paramView, int paramInt1, int paramInt2, az paramaz)
  {
    a(paramawd, paramView, paramInt1, paramInt2, g.a.opy, paramaz);
  }
  
  public final void a(awd paramawd, View paramView, int paramInt, g.a parama, az paramaz)
  {
    a(paramawd, paramView, -1, paramInt, parama, paramaz);
  }
  
  public final void a(awd paramawd, View paramView, int paramInt, az paramaz)
  {
    b(paramawd, paramView, -1, paramInt, paramaz);
  }
  
  public final void a(List<awd> paramList, View paramView, int paramInt, g.a parama, az paramaz)
  {
    a(paramList, paramView, paramInt, parama, paramaz, false);
  }
  
  public final void a(final List<awd> paramList, View paramView, int paramInt, g.a parama, final az paramaz, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (paramList.size() != 1) {
            break;
          }
          if (!paramBoolean)
          {
            b((awd)paramList.get(0), paramView, paramInt, paramaz);
            return;
          }
          paramList = (awd)paramList.get(0);
          localObject = g.a.opz;
        } while ((paramList == null) || (paramList.lsK == null) || (paramList.lsK.equals("")));
        paramView.setDrawingCacheEnabled(false);
        parama = i.aG(5, paramList.lsK);
        a(paramView, parama, -1, paramInt, (g.a)localObject);
        localObject = paramList.lsK;
        localObject = Nr(parama);
        if (i.b((com.tencent.mm.memory.n)localObject)) {
          break;
        }
        cN(paramView);
      } while (this.opl.contains(parama));
      a(5, paramList, paramaz);
      return;
      a(paramView, parama, (com.tencent.mm.memory.n)localObject);
      return;
      localObject = i.aG(0, i.cu(paramList));
      a(paramView, (String)localObject, true, -1, paramInt, -1, -1, parama);
      parama = Nr((String)localObject);
      paramBoolean = i.b(parama);
      y.v("MicroMsg.LazyerImageLoader2", "set Sns GridList " + paramBoolean);
      if (paramBoolean) {
        break;
      }
      cN(paramView);
    } while (this.opl.contains(localObject));
    new WeakReference(paramView);
    af.bDs().post(new Runnable()
    {
      public final void run()
      {
        long l = bk.UZ();
        Object localObject = new com.tencent.mm.plugin.sns.data.e(paramList);
        ((com.tencent.mm.plugin.sns.data.e)localObject).lJQ = i.cu(paramList);
        ((com.tencent.mm.plugin.sns.data.e)localObject).omU = this.opo;
        int j = 0;
        int k = 1;
        if ((j < paramList.size()) && (j < 4))
        {
          awd localawd = (awd)paramList.get(j);
          if (af.bDA().Nm(localawd.lsK)) {
            i = 0;
          }
          do
          {
            do
            {
              do
              {
                j += 1;
                k = i;
                break;
                i = k;
              } while (com.tencent.mm.vfs.e.bK(an.eJ(af.getAccSnsPath(), localawd.lsK) + i.e(localawd)));
              i = k;
            } while (com.tencent.mm.vfs.e.bK(an.eJ(af.getAccSnsPath(), localawd.lsK) + i.l(localawd)));
            i = k;
          } while (com.tencent.mm.vfs.e.bK(an.eJ(af.getAccSnsPath(), localawd.lsK) + i.m(localawd)));
          b localb = af.bDA();
          if (localawd.hQR == 6) {}
          for (int i = 5;; i = 1)
          {
            localb.a(localawd, i, (com.tencent.mm.plugin.sns.data.e)localObject, paramaz);
            i = 0;
            break;
          }
        }
        l = bk.cp(l);
        if (l > 100L) {
          y.i("MicroMsg.LazyerImageLoader2", "fileexist check2  endtime " + l + " " + Thread.currentThread().getName() + " " + com.tencent.mm.compatible.util.e.bkF + " " + af.bDS() + " " + ((com.tencent.mm.plugin.sns.data.e)localObject).lJQ);
        }
        if (bk.cp(g.c(g.this)) > 60000L)
        {
          h.nFQ.f(11696, new Object[] { Integer.valueOf(1), Long.valueOf(l), Integer.valueOf(0), Thread.currentThread().getName(), af.bDS(), com.tencent.mm.compatible.util.e.bkF });
          g.a(g.this, bk.UZ());
        }
        localObject = i.cu(paramList);
        if (k != 0) {
          af.aXq().post(new g.4.1(this, (String)localObject));
        }
      }
    });
    return;
    a(paramView, (String)localObject, parama);
  }
  
  public final boolean a(com.tencent.mm.plugin.sight.decode.a.a parama, int paramInt)
  {
    a(parama, "", -1, paramInt);
    parama.setThumbBmp(null);
    parama.aW(null, false);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.sns.storage.n paramn, awd paramawd, com.tencent.mm.plugin.sight.decode.a.a parama, int paramInt1, int paramInt2, az paramaz, boolean paramBoolean)
  {
    return a(paramn, paramawd, parama, paramInt1, paramInt2, paramaz, paramBoolean, false);
  }
  
  public final boolean a(com.tencent.mm.plugin.sns.storage.n paramn, awd paramawd, com.tencent.mm.plugin.sight.decode.a.a parama, int paramInt1, int paramInt2, az paramaz, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramawd == null) || (paramawd.lsK == null) || (paramawd.lsK.equals(""))) {
      return false;
    }
    String str1 = i.aG(1, paramawd.lsK);
    a(parama, str1, -1, paramInt1);
    String str2 = an.eJ(af.getAccSnsPath(), paramawd.lsK);
    String str3 = i.e(paramawd);
    Object localObject1;
    Object localObject2;
    if (!com.tencent.mm.vfs.e.bK(str2 + str3))
    {
      localObject1 = new com.tencent.mm.plugin.sns.data.e(paramawd);
      ((com.tencent.mm.plugin.sns.data.e)localObject1).omU = 1;
      ((com.tencent.mm.plugin.sns.data.e)localObject1).lJQ = paramawd.lsK;
      localObject2 = af.bDA();
      if (paramawd.hQR == 6)
      {
        paramInt1 = 5;
        ((b)localObject2).a(paramawd, paramInt1, (com.tencent.mm.plugin.sns.data.e)localObject1, paramaz);
      }
    }
    else
    {
      localObject1 = "";
      if (paramBoolean1)
      {
        if (u(paramawd)) {
          break label514;
        }
        localObject1 = an.eJ(af.getAccSnsPath(), paramawd.lsK);
        localObject2 = i.j(paramawd);
        if (!com.tencent.mm.vfs.e.bK((String)localObject1 + (String)localObject2)) {
          break label361;
        }
        localObject1 = (String)localObject1 + (String)localObject2;
      }
      label229:
      y.i("MicroMsg.LazyerImageLoader2", "setsight %s sightPath %s isAd %b", new Object[] { str1, localObject1, Boolean.valueOf(paramBoolean1) });
      if ((bk.bl((String)localObject1)) || (u(paramawd))) {
        break label544;
      }
      if (!((String)localObject1).equals(parama.getVideoPath()))
      {
        if (!paramBoolean2) {
          break label533;
        }
        paramn = BitmapFactory.decodeFile(str2 + str3);
        label318:
        parama.setThumbBmp(paramn);
      }
      if (this.ooI) {
        break label538;
      }
    }
    label514:
    label522:
    label533:
    label538:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      parama.aW((String)localObject1, paramBoolean1);
      parama.setPosition(paramInt2);
      return true;
      paramInt1 = 1;
      break;
      label361:
      if ((com.tencent.mm.vfs.e.bK((String)localObject1 + i.p(paramawd))) && (paramawd.lsK != null) && (paramawd.lsK.startsWith("Locall_path")))
      {
        localObject1 = (String)localObject1 + i.p(paramawd);
        break label229;
      }
      if (this.ooI)
      {
        y.i("MicroMsg.LazyerImageLoader2", "push sight loader " + paramawd.lsK + " url: " + paramawd.kSC);
        if (!paramBoolean1) {
          break label522;
        }
        if (b(paramn, null) == 5) {
          af.aXq().postDelayed(new g.8(this, paramawd, paramaz), 0L);
        }
      }
      for (;;)
      {
        localObject1 = "";
        break;
        y.i("MicroMsg.LazyerImageLoader2", "do no auto download sns sight.");
      }
      paramn = null;
      break label318;
    }
    label544:
    y.i("MicroMsg.LazyerImageLoader2", "sightPath %s", new Object[] { localObject1 });
    if (!this.ooI)
    {
      paramBoolean1 = true;
      parama.aW(null, paramBoolean1);
      paramn = paramawd.lsK;
      paramn = Nr(str1);
      paramBoolean1 = i.b(paramn);
      y.v("MicroMsg.LazyerImageLoader2", "setsight thumb  %s", new Object[] { Boolean.valueOf(paramBoolean1) });
      if (paramBoolean1) {
        break label726;
      }
      if ((!(parama instanceof ImageView)) && (!(parama instanceof QFadeImageView))) {
        break label666;
      }
      cN((View)parama);
    }
    for (;;)
    {
      if (this.opl.contains(str1))
      {
        return false;
        paramBoolean1 = false;
        break;
        label666:
        if ((parama instanceof com.tencent.mm.plugin.sight.decode.a.a))
        {
          if (!this.ooI) {}
          for (paramBoolean1 = true;; paramBoolean1 = false)
          {
            parama.aW(null, paramBoolean1);
            parama.setPosition(0);
            parama.setThumbBmp(null);
            break;
          }
        }
      }
    }
    a(1, paramawd, paramaz);
    return false;
    label726:
    a(parama, str1, paramn);
    return true;
  }
  
  public final boolean a(awd paramawd, View paramView, int paramInt1, int paramInt2, az paramaz, int paramInt3)
  {
    boolean bool1 = true;
    if ((paramawd == null) || (paramawd.lsK == null) || (paramawd.lsK.equals(""))) {
      bool1 = false;
    }
    String str;
    Object localObject;
    do
    {
      return bool1;
      str = i.aG(paramInt3, paramawd.lsK);
      a(paramView, str, paramInt1, paramInt2);
      localObject = paramawd.lsK;
      localObject = Nr(str);
      boolean bool2 = i.b((com.tencent.mm.memory.n)localObject);
      y.v("MicroMsg.LazyerImageLoader2", "set sns Thumb  " + bool2 + str);
      if (bool2) {
        break;
      }
      if (paramInt1 == -1) {
        cN(paramView);
      }
    } while (this.opl.contains(str));
    a(paramInt3, paramawd, paramaz);
    return false;
    a(paramView, str, (com.tencent.mm.memory.n)localObject);
    return true;
  }
  
  public final boolean a(String paramString, com.tencent.mm.memory.n paramn, int paramInt)
  {
    a(paramInt + "-" + paramString, paramn);
    return true;
  }
  
  public final int b(com.tencent.mm.plugin.sns.storage.n paramn, int[] paramArrayOfInt)
  {
    int j = 5;
    Object localObject;
    PInt localPInt;
    if ((paramArrayOfInt != null) || (bk.cp(this.opc) > 60000L))
    {
      localObject = new PInt();
      localPInt = new PInt();
      com.tencent.mm.modelcontrol.c.Ni();
      if (!com.tencent.mm.modelcontrol.c.a((PInt)localObject, localPInt)) {
        break label116;
      }
      this.opi = 5;
      if (paramArrayOfInt != null) {
        if (((PInt)localObject).value != 0) {
          break label125;
        }
      }
    }
    label116:
    label125:
    for (int i = 0;; i = 1)
    {
      paramArrayOfInt[0] = i;
      paramArrayOfInt[1] = localPInt.value;
      this.opj = ((PInt)localObject).value;
      this.opc = bk.UZ();
      if ((this.opj != 0) && (paramn != null)) {
        break label130;
      }
      return this.opi;
      this.opi = 10;
      break;
    }
    label130:
    if (this.opk.containsKey(Long.valueOf(paramn.field_snsId))) {
      return ((Integer)this.opk.get(Long.valueOf(paramn.field_snsId))).intValue();
    }
    paramArrayOfInt = new btw();
    try
    {
      localObject = (bto)new bto().aH(paramn.field_attrBuf);
      if (((bto)localObject).tKl == null) {
        return this.opi;
      }
      paramArrayOfInt.aH(((bto)localObject).tKl.tFM.oY);
      if ((paramArrayOfInt.tKA == null) || (paramArrayOfInt.tKA.info == null))
      {
        i = this.opd;
        return i;
      }
    }
    catch (Exception paramn)
    {
      y.printErrStackTrace("MicroMsg.LazyerImageLoader2", paramn, "", new Object[0]);
      return this.opi;
    }
    paramArrayOfInt = paramArrayOfInt.tKA.info;
    i = paramArrayOfInt.hashCode();
    if (this.opj == 1)
    {
      if (!this.oph.containsKey(Integer.valueOf(i))) {
        this.oph.put(Integer.valueOf(i), Boolean.valueOf(cn(paramArrayOfInt, this.opj)));
      }
      if (((Boolean)this.oph.get(Integer.valueOf(i))).booleanValue()) {}
      for (i = 5;; i = 10)
      {
        y.i("MicroMsg.LazyerImageLoader2", "isAutoAdDownload(sight_autodownload) snsID:%d, result:%d", new Object[] { Long.valueOf(paramn.field_snsId), Integer.valueOf(i) });
        this.opk.put(Long.valueOf(paramn.field_snsId), Integer.valueOf(i));
        return i;
      }
    }
    if (!this.opg.containsKey(Integer.valueOf(i))) {
      this.opg.put(Integer.valueOf(i), Boolean.valueOf(cn(paramArrayOfInt, this.opj)));
    }
    if (((Boolean)this.opg.get(Integer.valueOf(i))).booleanValue()) {}
    for (i = j;; i = 10) {
      break;
    }
  }
  
  public final Bitmap b(awd paramawd)
  {
    if ((paramawd == null) || (paramawd.lsK == null) || (paramawd.lsK.equals(""))) {
      return null;
    }
    String str1 = i.aG(1, paramawd.lsK);
    Object localObject = paramawd.lsK;
    localObject = Nr(str1);
    if (i.b((com.tencent.mm.memory.n)localObject)) {
      return ((com.tencent.mm.memory.n)localObject).Fd();
    }
    localObject = an.eJ(af.getAccSnsPath(), paramawd.lsK);
    String str2 = i.e(paramawd);
    localObject = (String)localObject + str2;
    if (com.tencent.mm.vfs.e.bK((String)localObject))
    {
      if (paramawd.lsK.startsWith("pre_temp_extend_pic")) {}
      for (paramawd = com.tencent.mm.memory.n.o(s.OS((String)localObject)); i.b(paramawd); paramawd = i.Na((String)localObject))
      {
        a(str1, paramawd);
        return paramawd.Fd();
      }
      return null;
    }
    return null;
  }
  
  public final void b(awd paramawd, View paramView, int paramInt, az paramaz)
  {
    a(paramawd, paramView, -1, paramInt, paramaz);
  }
  
  protected final void b(String paramString, com.tencent.mm.memory.n paramn)
  {
    com.tencent.mm.memory.n localn = paramn;
    if (!i.b(paramn))
    {
      localn = (com.tencent.mm.memory.n)this.ooR.get(paramString);
      if (localn != null)
      {
        paramn = localn;
        if (!localn.isRecycled()) {}
      }
      else
      {
        this.ooR.remove(paramString);
        paramn = null;
      }
      localn = paramn;
    }
    if (i.b(localn))
    {
      if ((this.ooR != null) && (localn != null) && (paramString != null)) {
        this.ooR.put(paramString, localn);
      }
      paramn = (LinkedList)this.ooT.get(paramString);
      if (paramn != null)
      {
        paramn = paramn.iterator();
        while (paramn.hasNext())
        {
          Object localObject = (g.c)((WeakReference)paramn.next()).get();
          if ((localObject != null) && (((g.c)localObject).opD) && (paramString != null) && (paramString.equals(((g.c)localObject).id)))
          {
            int i = ((g.c)localObject).code;
            localObject = (WeakReference)this.enZ.get(Integer.valueOf(i));
            if (localObject != null)
            {
              localObject = ((WeakReference)localObject).get();
              if (localObject != null)
              {
                if ((localObject instanceof QFadeImageView))
                {
                  QFadeImageView localQFadeImageView = (QFadeImageView)localObject;
                  if ((this.opa != null) && ((localQFadeImageView instanceof TagImageView)))
                  {
                    i = ((TagImageView)localQFadeImageView).getPosition();
                    if ((i != -1) && (!this.opa.yz(i))) {
                      continue;
                    }
                  }
                }
                if ((i.b(localn)) && (localObject != null))
                {
                  a(localObject, paramString, localn);
                }
                else
                {
                  boolean bool1;
                  if (localn == null)
                  {
                    bool1 = true;
                    label296:
                    if (localObject != null) {
                      break label352;
                    }
                  }
                  label352:
                  for (boolean bool2 = true;; bool2 = false)
                  {
                    y.d("MicroMsg.LazyerImageLoader2", "setRefImageView null bmNUll: %s ivNull: %s bimapavailable %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(i.b(localn)) });
                    break;
                    bool1 = false;
                    break label296;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final boolean b(awd paramawd, View paramView, int paramInt1, int paramInt2, az paramaz)
  {
    return a(paramawd, paramView, paramInt1, paramInt2, paramaz, 1);
  }
  
  public final void bCU()
  {
    if (this.ooR != null)
    {
      this.enZ.clear();
      this.ooS.otf.clear();
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("mMemoryCache \n");
      localStringBuffer.append("putCount:" + this.ooR.putCount() + ";");
      localStringBuffer.append("missCount:" + this.ooR.missCount() + ";");
      localStringBuffer.append("hitCount:" + this.ooR.hitCount() + ";");
      localStringBuffer.append("createCount:" + this.ooR.createCount() + ";");
      localStringBuffer.append("evictionCount:" + this.ooR.evictionCount() + ";");
      y.i("MicroMsg.LazyerImageLoader2", "report lurcache ");
      this.ooR.trimToSize(-1);
    }
    this.ooS.bEb();
    System.gc();
  }
  
  public final void bCm()
  {
    bCU();
    this.opb = 0L;
    this.opc = 0L;
    this.ooV.clear();
    this.ooW = false;
  }
  
  public final void c(awd paramawd, View paramView, int paramInt, az paramaz)
  {
    if ((paramawd == null) || (paramawd.lsK == null) || (paramawd.lsK.equals(""))) {}
    String str;
    Object localObject;
    do
    {
      return;
      str = i.aG(4, paramawd.lsK);
      a(paramView, str, -1, paramInt);
      localObject = paramawd.lsK;
      localObject = Nr(str);
      boolean bool = i.b((com.tencent.mm.memory.n)localObject);
      y.v("MicroMsg.LazyerImageLoader2", "set sns Thumb  " + bool);
      if (bool) {
        break;
      }
      cN(paramView);
    } while (this.opl.contains(str));
    a(4, paramawd, paramaz);
    return;
    a(paramView, str, (com.tencent.mm.memory.n)localObject);
  }
  
  public final void cM(View paramView)
  {
    if ((paramView instanceof ImageView)) {
      ((ImageView)paramView).setImageBitmap(null);
    }
    while (!(paramView instanceof QImageView)) {
      return;
    }
    ((QImageView)paramView).setImageBitmap(null);
  }
  
  public final boolean cO(View paramView)
  {
    int i = paramView.hashCode();
    paramView = this.ooX.iterator();
    while (paramView.hasNext())
    {
      g.c localc = (g.c)paramView.next();
      if (i == localc.code) {
        this.ooX.remove(localc);
      }
    }
    this.enZ.remove(Integer.valueOf(i));
    return true;
  }
  
  public final boolean eH(String paramString1, String paramString2)
  {
    if ((this.ooY.containsKey(paramString1)) && (3 == ((Integer)this.ooY.get(paramString1)).intValue())) {
      this.ooY.remove(paramString1);
    }
    String str = i.aG(1, paramString1);
    Object localObject1 = (LinkedList)this.ooT.get(str);
    if (localObject1 == null) {
      return false;
    }
    localObject1 = ((LinkedList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (g.c)((WeakReference)((Iterator)localObject1).next()).get();
      if ((localObject2 != null) && (((g.c)localObject2).opD) && (str != null) && (str.equals(((g.c)localObject2).id)))
      {
        int i = ((g.c)localObject2).code;
        localObject2 = (WeakReference)this.enZ.get(Integer.valueOf(i));
        if (localObject2 != null)
        {
          localObject2 = ((WeakReference)localObject2).get();
          if ((localObject2 != null) && ((localObject2 instanceof com.tencent.mm.plugin.sight.decode.a.a)))
          {
            y.i("MicroMsg.LazyerImageLoader2", "download fin set sight %s %s", new Object[] { paramString1, paramString2 });
            localObject2 = (com.tencent.mm.plugin.sight.decode.a.a)localObject2;
            if ((((com.tencent.mm.plugin.sight.decode.a.a)localObject2).getTagObject() instanceof aj))
            {
              aj localaj = (aj)((com.tencent.mm.plugin.sight.decode.a.a)localObject2).getTagObject();
              boolean bool;
              if (localaj != null)
              {
                if (com.tencent.mm.vfs.e.bK(paramString2))
                {
                  if (!this.ooI) {}
                  for (bool = true;; bool = false)
                  {
                    ((com.tencent.mm.plugin.sight.decode.a.a)localObject2).aW(paramString2, bool);
                    ((com.tencent.mm.plugin.sight.decode.a.a)localObject2).setPosition(localaj.position);
                    localaj.oTI.setVisibility(8);
                    localaj.oGT.setVisibility(8);
                    localaj.oGU.setVisibility(8);
                    if ((!this.ooY.containsKey(paramString1)) || (4 != ((Integer)this.ooY.get(paramString1)).intValue())) {
                      break;
                    }
                    this.ooY.remove(paramString1);
                    break;
                  }
                }
                this.ooY.put(paramString1, Integer.valueOf(4));
                localaj.oTI.setVisibility(8);
                localaj.oGT.setImageResource(i.e.sight_chat_error);
                localaj.oGT.setVisibility(0);
              }
              else
              {
                if (!this.ooI) {}
                for (bool = true;; bool = false)
                {
                  ((com.tencent.mm.plugin.sight.decode.a.a)localObject2).aW(paramString2, bool);
                  break;
                }
              }
            }
          }
        }
      }
    }
    return true;
  }
  
  public final int n(com.tencent.mm.plugin.sns.storage.n paramn)
  {
    return a(paramn, null);
  }
  
  public final int o(com.tencent.mm.plugin.sns.storage.n paramn)
  {
    return b(paramn, null);
  }
  
  public final void pause()
  {
    this.ooI = false;
    b localb = af.bDA();
    localb.ooI = false;
    Object localObject3;
    synchronized (localb.dIn)
    {
      localObject2 = new LinkedList();
      localObject3 = localb.dtH.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        com.tencent.mm.plugin.sns.data.f localf = (com.tencent.mm.plugin.sns.data.f)((Iterator)localObject3).next();
        if (localf.requestType != 6)
        {
          localb.ooL.remove(localf.key);
          ((LinkedList)localObject2).add(localf);
        }
      }
    }
    Object localObject2 = ((LinkedList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (com.tencent.mm.plugin.sns.data.f)((Iterator)localObject2).next();
      localObject1.dtH.remove(localObject3);
    }
  }
  
  public final void start()
  {
    this.ooI = true;
    bCV();
    b localb = af.bDA();
    localb.ooI = true;
    localb.Om();
  }
  
  public final boolean u(awd paramawd)
  {
    if (!this.ooY.containsKey(paramawd.lsK)) {
      return false;
    }
    return ((Integer)this.ooY.get(paramawd.lsK)).intValue() == 1;
  }
  
  public final boolean v(awd paramawd)
  {
    if (!this.ooY.containsKey(paramawd.lsK)) {
      return false;
    }
    return ((Integer)this.ooY.get(paramawd.lsK)).intValue() == 2;
  }
  
  public final boolean w(awd paramawd)
  {
    if (!this.ooY.containsKey(paramawd.lsK)) {
      return false;
    }
    return ((Integer)this.ooY.get(paramawd.lsK)).intValue() == 3;
  }
  
  public final boolean x(awd paramawd)
  {
    if (!this.ooY.containsKey(paramawd.lsK)) {
      return false;
    }
    return ((Integer)this.ooY.get(paramawd.lsK)).intValue() == 4;
  }
  
  public final void y(awd paramawd)
  {
    this.ooY.put(paramawd.lsK, Integer.valueOf(1));
  }
  
  public final void z(awd paramawd)
  {
    this.ooY.put(paramawd.lsK, Integer.valueOf(2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.g
 * JD-Core Version:    0.7.0.1
 */