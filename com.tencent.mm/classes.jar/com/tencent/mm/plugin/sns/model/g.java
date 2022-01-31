package com.tencent.mm.plugin.sns.model;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.c;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.x;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.sdk.platformtools.d;
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
  private static int rdK = 0;
  private Map<Integer, WeakReference<Object>> fEx;
  public long rdA;
  private int rdB;
  private int rdC;
  private HashMap<Long, Integer> rdD;
  private HashMap<Integer, Boolean> rdE;
  private HashMap<Integer, Boolean> rdF;
  private int rdG;
  private int rdH;
  private HashMap<Long, Integer> rdI;
  protected Set<String> rdJ;
  public boolean rdd;
  private long rdn;
  private long rdo;
  com.tencent.mm.memory.a.b<com.tencent.mm.memory.n> rdp;
  private am<String, WeakReference<Bitmap>> rdq;
  private Map<String, LinkedList<WeakReference<g.c>>> rdr;
  private ConcurrentHashMap<Integer, String> rds;
  private LinkedList<g.b> rdt;
  private boolean rdu;
  private HashSet<g.c> rdv;
  public HashMap<String, Integer> rdw;
  private int rdx;
  public x rdy;
  public long rdz;
  
  public g()
  {
    AppMethodBeat.i(36159);
    this.rdn = 0L;
    this.rdo = 0L;
    this.fEx = new HashMap();
    this.rdr = new HashMap();
    this.rds = new ConcurrentHashMap();
    this.rdt = new LinkedList();
    this.rdu = false;
    this.rdv = new HashSet();
    this.rdw = new HashMap();
    this.rdx = 4;
    this.rdd = true;
    this.rdz = 0L;
    this.rdA = 0L;
    this.rdB = 0;
    this.rdC = 0;
    this.rdD = new HashMap();
    this.rdE = new HashMap();
    this.rdF = new HashMap();
    this.rdG = 0;
    this.rdH = 0;
    this.rdI = new HashMap();
    this.rdJ = new HashSet();
    com.tencent.mm.memory.a.b.a(com.tencent.mm.memory.n.class, new g.1(this));
    int i = ((ActivityManager)ah.getContext().getSystemService("activity")).getLargeMemoryClass();
    ab.i("MicroMsg.LazyerImageLoader2", "BitmapPool %dMB", new Object[] { Integer.valueOf(i) });
    if (i > 256) {}
    for (i = 62914560;; i = 31457280)
    {
      this.rdp = new com.tencent.mm.memory.a.b(i, new g.4(this), getClass());
      this.rdq = new am(this.rdx, new g.5(this));
      AppMethodBeat.o(36159);
      return;
    }
  }
  
  public static String C(bcs parambcs)
  {
    AppMethodBeat.i(36217);
    if (parambcs == null)
    {
      AppMethodBeat.o(36217);
      return null;
    }
    if (parambcs.Id.startsWith("pre_temp_sns_pic")) {
      parambcs = ag.getAccSnsTmpPath() + parambcs.Id;
    }
    for (;;)
    {
      AppMethodBeat.o(36217);
      return parambcs;
      if (parambcs.Id.startsWith("Locall_path")) {
        parambcs = ao.gl(ag.getAccSnsPath(), parambcs.Id) + i.m(parambcs);
      } else if (parambcs.Id.startsWith("pre_temp_extend_pic")) {
        parambcs = parambcs.Id.substring(19);
      } else {
        parambcs = ao.gl(ag.getAccSnsPath(), parambcs.Id) + i.d(parambcs);
      }
    }
  }
  
  public static Bitmap a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, az paramaz)
  {
    AppMethodBeat.i(36214);
    if ((!paramBoolean) && (bo.isNullOrNil(paramString1)))
    {
      AppMethodBeat.o(36214);
      return null;
    }
    bcs localbcs = com.tencent.mm.modelsns.e.a(paramString3, 2, paramString2, paramString2, 1, 1, "");
    i.bc(2, paramString3);
    if (paramString3.equals(""))
    {
      paramString1 = i.ZG(paramString1);
      if (i.A(paramString1))
      {
        AppMethodBeat.o(36214);
        return paramString1;
      }
      AppMethodBeat.o(36214);
      return null;
    }
    if (i.A(null))
    {
      AppMethodBeat.o(36214);
      return null;
    }
    Object localObject = i.l(localbcs);
    localObject = i.ZG(ao.gl(ag.getAccSnsPath(), paramString3) + (String)localObject);
    paramString3 = (String)localObject;
    if (!i.A((Bitmap)localObject)) {
      paramString3 = i.ZG(paramString1);
    }
    if ((paramString3 == null) && (paramBoolean) && (!bo.isNullOrNil(paramString2))) {
      ag.cpa().a(localbcs, 3, null, paramaz);
    }
    if (!i.A(paramString3))
    {
      AppMethodBeat.o(36214);
      return null;
    }
    AppMethodBeat.o(36214);
    return paramString3;
  }
  
  private String a(com.tencent.mm.plugin.sns.storage.n paramn, bcs parambcs, az paramaz, boolean paramBoolean)
  {
    AppMethodBeat.i(36207);
    if (u(parambcs))
    {
      AppMethodBeat.o(36207);
      return "";
    }
    String str1 = ao.gl(ag.getAccSnsPath(), parambcs.Id);
    String str2 = i.j(parambcs);
    if (com.tencent.mm.vfs.e.cN(str1 + str2))
    {
      paramn = str1 + str2;
      AppMethodBeat.o(36207);
      return paramn;
    }
    if ((com.tencent.mm.vfs.e.cN(str1 + i.p(parambcs))) && (parambcs.Id != null) && (parambcs.Id.startsWith("Locall_path")))
    {
      paramn = str1 + i.p(parambcs);
      AppMethodBeat.o(36207);
      return paramn;
    }
    if (!this.rdd)
    {
      AppMethodBeat.o(36207);
      return "";
    }
    ab.i("MicroMsg.LazyerImageLoader2", "push sight loader " + parambcs.Id + " url: " + parambcs.Url);
    if (paramBoolean) {
      if (b(paramn, null) == 5) {
        ag.bEf().postDelayed(new g.11(this, parambcs, paramaz), 0L);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(36207);
      return "";
      ab.i("MicroMsg.LazyerImageLoader2", "do no auto download sns sight.");
    }
  }
  
  private void a(View paramView, String paramString, int paramInt, g.a parama)
  {
    AppMethodBeat.i(36186);
    a(paramView, paramString, true, -1, paramInt, -1, -1, parama);
    AppMethodBeat.o(36186);
  }
  
  private void a(Object paramObject, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36187);
    a(paramObject, paramString, true, paramInt1, paramInt2, -1, -1, g.a.rea);
    AppMethodBeat.o(36187);
  }
  
  private void a(Object paramObject, String paramString, int paramInt1, int paramInt2, g.a parama)
  {
    AppMethodBeat.i(36188);
    a(paramObject, paramString, true, paramInt1, paramInt2, -1, -1, parama);
    AppMethodBeat.o(36188);
  }
  
  private static void a(Object paramObject, String paramString, com.tencent.mm.memory.n paramn)
  {
    long l2 = 0L;
    AppMethodBeat.i(36175);
    if (paramObject == null)
    {
      AppMethodBeat.o(36175);
      return;
    }
    if (paramn != null) {
      ab.i("MicroMsg.LazyerImageLoader2", "setImageDrawable %s %s %s", new Object[] { paramObject, paramString, paramn.XX() });
    }
    Object localObject;
    long l1;
    if ((paramObject instanceof QFadeImageView))
    {
      paramObject = (QFadeImageView)paramObject;
      localObject = paramObject.getDrawable();
      l1 = l2;
      if (!bo.isNullOrNil(paramObject.getImageKey()))
      {
        l1 = l2;
        if (paramObject.getImageKey().equals(paramString)) {
          l1 = paramObject.getStartTimeMillis();
        }
      }
      if ((localObject == null) || (!(localObject instanceof aj))) {
        break label375;
      }
      l1 = ((aj)localObject).nhl;
    }
    label361:
    label375:
    for (;;)
    {
      paramn = new aj(paramString, paramn, l1);
      paramObject.E(paramn.nhl, paramString);
      paramObject.setImageDrawable(paramn);
      paramn.invalidateSelf();
      AppMethodBeat.o(36175);
      return;
      if ((paramObject instanceof QDisFadeImageView))
      {
        paramObject = (QDisFadeImageView)paramObject;
        paramString = new com.tencent.mm.memory.b.a(paramString, paramn);
        paramObject.setImageDrawable(paramString);
        paramString.invalidateSelf();
        AppMethodBeat.o(36175);
        return;
      }
      if ((paramObject instanceof ImageView))
      {
        localObject = (ImageView)paramObject;
        paramObject = ((ImageView)localObject).getDrawable();
        if ((paramObject != null) && ((paramObject instanceof aj))) {}
        for (paramObject = new aj(paramString, paramn, ((aj)paramObject).nhl);; paramObject = new aj(paramString, paramn, 0L))
        {
          ((ImageView)localObject).setImageDrawable(paramObject);
          paramObject.invalidateSelf();
          AppMethodBeat.o(36175);
          return;
        }
      }
      if ((paramObject instanceof com.tencent.mm.plugin.sight.decode.a.a))
      {
        ab.i("MicroMsg.LazyerImageLoader2", "update sight thumb ".concat(String.valueOf(paramString)));
        if ((paramObject instanceof SightPlayImageView))
        {
          localObject = (SightPlayImageView)paramObject;
          paramObject = ((SightPlayImageView)localObject).getDrawable();
          if ((paramObject == null) || (!(paramObject instanceof aj))) {
            break label361;
          }
        }
      }
      for (paramObject = new aj(paramString, paramn, ((aj)paramObject).nhl);; paramObject = new aj(paramString, paramn, 0L))
      {
        ((SightPlayImageView)localObject).setImageDrawable(paramObject);
        paramObject.invalidateSelf();
        AppMethodBeat.o(36175);
        return;
      }
    }
  }
  
  private void a(Object paramObject, String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, g.a parama)
  {
    AppMethodBeat.i(36189);
    if (paramObject == null)
    {
      AppMethodBeat.o(36189);
      return;
    }
    int i = paramObject.hashCode();
    this.rdv.remove(new g.c(null, i, 0, false));
    g.c localc = new g.c(paramString, i, paramInt2, paramBoolean);
    this.rdv.add(localc);
    LinkedList localLinkedList = (LinkedList)this.rdr.get(paramString);
    Object localObject = localLinkedList;
    if (localLinkedList == null)
    {
      localObject = new LinkedList();
      this.rdr.put(paramString, localObject);
    }
    ((LinkedList)localObject).add(new WeakReference(localc));
    localObject = (String)((View)paramObject).getTag(2130706432);
    if (localObject != null)
    {
      localLinkedList = (LinkedList)this.rdr.get(localObject);
      if (localLinkedList != null)
      {
        paramInt2 = 0;
        if (paramInt2 >= localLinkedList.size()) {
          break label493;
        }
        localc = (g.c)((WeakReference)localLinkedList.get(paramInt2)).get();
        if ((localc == null) || (localc.code != i)) {
          break label343;
        }
      }
    }
    for (;;)
    {
      if (paramInt2 != -1)
      {
        ab.v("MicroMsg.LazyerImageLoader2", "updateImageViewToKey remove last pair %s", new Object[] { localObject });
        localLinkedList.remove(paramInt2);
      }
      ((View)paramObject).setTag(2130706432, paramString);
      localObject = new WeakReference(paramObject);
      this.fEx.put(Integer.valueOf(i), localObject);
      if (paramInt1 != -1)
      {
        if (!(paramObject instanceof QFadeImageView)) {
          break label352;
        }
        ((QFadeImageView)paramObject).setImageResource(paramInt1);
      }
      for (;;)
      {
        if ((parama == g.a.reb) && (((paramObject instanceof ImageView)) || ((paramObject instanceof QFadeImageView))))
        {
          com.tencent.mm.sdk.platformtools.n.cn((View)paramObject);
          AppMethodBeat.o(36189);
          return;
          label343:
          paramInt2 += 1;
          break;
          label352:
          if ((paramObject instanceof ImageView))
          {
            ((ImageView)paramObject).setImageDrawable(com.tencent.mm.cb.a.k(((ImageView)paramObject).getContext(), paramInt1));
          }
          else
          {
            localObject = (com.tencent.mm.plugin.sight.decode.a.a)paramObject;
            if (!this.rdd) {}
            for (paramBoolean = true;; paramBoolean = false)
            {
              ((com.tencent.mm.plugin.sight.decode.a.a)localObject).bl(null, paramBoolean);
              break;
            }
          }
        }
      }
      if ((paramString != null) && (paramString.startsWith("3")) && (((paramObject instanceof ImageView)) || ((paramObject instanceof QFadeImageView))))
      {
        com.tencent.mm.sdk.platformtools.n.x((View)paramObject, paramInt3, paramInt4);
        ab.d("MicroMsg.LazyerImageLoader2", "try to setlayerType " + paramInt3 + " " + paramInt4);
      }
      AppMethodBeat.o(36189);
      return;
      label493:
      paramInt2 = -1;
    }
  }
  
  private boolean a(int paramInt, bcs parambcs, az paramaz)
  {
    AppMethodBeat.i(36193);
    if (!this.rdd)
    {
      if ((parambcs != null) && (!bo.isNullOrNil(parambcs.Id))) {
        ag.cpa().aag(parambcs.Id);
      }
      AppMethodBeat.o(36193);
      return false;
    }
    ag.coS().execute(new g.10(this, paramInt, parambcs, paramaz));
    AppMethodBeat.o(36193);
    return true;
  }
  
  public static boolean a(bcs parambcs, az paramaz, boolean paramBoolean)
  {
    AppMethodBeat.i(36216);
    if ((parambcs == null) || (parambcs.Id == null) || (parambcs.Id.equals("")))
    {
      AppMethodBeat.o(36216);
      return false;
    }
    Object localObject;
    if (parambcs.Id.startsWith("Locall_path"))
    {
      localObject = ao.gl(ag.getAccSnsPath(), parambcs.Id) + i.m(parambcs);
      if (com.tencent.mm.vfs.e.cN((String)localObject)) {
        break label160;
      }
      localObject = ag.cpa();
      if (!paramBoolean) {
        break label155;
      }
    }
    label155:
    for (int i = 8;; i = 2)
    {
      ((b)localObject).a(parambcs, i, null, paramaz);
      AppMethodBeat.o(36216);
      return false;
      localObject = ao.gl(ag.getAccSnsPath(), parambcs.Id) + i.d(parambcs);
      break;
    }
    label160:
    AppMethodBeat.o(36216);
    return true;
  }
  
  private boolean a(String paramString, com.tencent.mm.memory.n paramn)
  {
    AppMethodBeat.i(36210);
    if ((paramn != null) && (paramString != null)) {
      this.rdp.put(paramString, paramn);
    }
    AppMethodBeat.o(36210);
    return true;
  }
  
  private boolean a(List<bcs> paramList, az paramaz)
  {
    AppMethodBeat.i(36191);
    ag.coS().execute(new g.7(this, paramList, paramaz));
    AppMethodBeat.o(36191);
    return true;
  }
  
  private com.tencent.mm.memory.n aak(String paramString)
  {
    AppMethodBeat.i(36170);
    com.tencent.mm.memory.n localn = (com.tencent.mm.memory.n)this.rdp.get(paramString);
    if ((localn == null) || (localn.isRecycled()))
    {
      this.rdp.remove(paramString);
      AppMethodBeat.o(36170);
      return null;
    }
    AppMethodBeat.o(36170);
    return localn;
  }
  
  private boolean ag(View paramView, int paramInt)
  {
    AppMethodBeat.i(36162);
    if (paramView.hashCode() == paramInt)
    {
      AppMethodBeat.o(36162);
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
      } while (!ag(paramView.getChildAt(j), paramInt));
      AppMethodBeat.o(36162);
      return true;
    }
    AppMethodBeat.o(36162);
    return false;
  }
  
  private void b(bcs parambcs, View paramView, int paramInt, g.a parama, az paramaz)
  {
    AppMethodBeat.i(36174);
    if ((parambcs == null) || (parambcs.Id == null) || (parambcs.Id.equals("")))
    {
      AppMethodBeat.o(36174);
      return;
    }
    paramView.setDrawingCacheEnabled(false);
    String str = i.bc(5, parambcs.Id);
    a(paramView, str, -1, paramInt, parama);
    parama = aaj(str);
    if (!i.b(parama))
    {
      dD(paramView);
      if (this.rdJ.contains(str))
      {
        AppMethodBeat.o(36174);
        return;
      }
      a(5, parambcs, paramaz);
      AppMethodBeat.o(36174);
      return;
    }
    a(paramView, str, parama);
    AppMethodBeat.o(36174);
  }
  
  private boolean cox()
  {
    AppMethodBeat.i(36192);
    if (this.rdu)
    {
      ab.i("MicroMsg.LazyerImageLoader2", "loaderlist size runing pass");
      AppMethodBeat.o(36192);
      return false;
    }
    ag.bEf().postDelayed(new g.8(this), 0L);
    AppMethodBeat.o(36192);
    return true;
  }
  
  private static void dD(View paramView)
  {
    AppMethodBeat.i(36185);
    if ((paramView instanceof QImageView))
    {
      ((QImageView)paramView).setImageResource(2130838904);
      AppMethodBeat.o(36185);
      return;
    }
    if ((paramView instanceof ImageView))
    {
      ((ImageView)paramView).setImageResource(2130838904);
      AppMethodBeat.o(36185);
      return;
    }
    AppMethodBeat.o(36185);
  }
  
  private static boolean dj(String paramString, int paramInt)
  {
    AppMethodBeat.i(36199);
    paramString = br.F(paramString, "SightDownloadControl");
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(36199);
      return true;
    }
    if (paramInt == 1)
    {
      if (bo.getInt((String)paramString.get(".SightDownloadControl.G3PlusAutoDownload"), 0) == 1)
      {
        AppMethodBeat.o(36199);
        return true;
      }
      AppMethodBeat.o(36199);
      return false;
    }
    if (bo.getInt((String)paramString.get(".SightDownloadControl.WifiAutoDownload"), 0) == 1)
    {
      AppMethodBeat.o(36199);
      return true;
    }
    AppMethodBeat.o(36199);
    return false;
  }
  
  public static String r(bcs parambcs)
  {
    AppMethodBeat.i(36176);
    if ((parambcs == null) || (parambcs.Id == null) || (parambcs.Id.equals("")))
    {
      AppMethodBeat.o(36176);
      return null;
    }
    String str = ao.gl(ag.getAccSnsPath(), parambcs.Id) + i.e(parambcs);
    if (!com.tencent.mm.vfs.e.cN(str))
    {
      parambcs = parambcs.xrS;
      AppMethodBeat.o(36176);
      return parambcs;
    }
    AppMethodBeat.o(36176);
    return str;
  }
  
  public static String s(bcs parambcs)
  {
    AppMethodBeat.i(36177);
    if ((parambcs == null) || (parambcs.Id == null) || (parambcs.Id.equals("")))
    {
      AppMethodBeat.o(36177);
      return null;
    }
    String str = ao.gl(ag.getAccSnsPath(), parambcs.Id) + i.d(parambcs);
    if (!com.tencent.mm.vfs.e.cN(str))
    {
      parambcs = parambcs.Url;
      AppMethodBeat.o(36177);
      return parambcs;
    }
    AppMethodBeat.o(36177);
    return str;
  }
  
  public static boolean t(bcs parambcs)
  {
    AppMethodBeat.i(36194);
    String str1 = ao.gl(ag.getAccSnsPath(), parambcs.Id);
    String str2 = i.j(parambcs);
    if (com.tencent.mm.vfs.e.cN(str1 + str2))
    {
      AppMethodBeat.o(36194);
      return true;
    }
    if ((com.tencent.mm.vfs.e.cN(str1 + i.p(parambcs))) && (!bo.isNullOrNil(parambcs.Id)) && (parambcs.Id.startsWith("Locall_path")))
    {
      AppMethodBeat.o(36194);
      return true;
    }
    AppMethodBeat.o(36194);
    return false;
  }
  
  public final void A(bcs parambcs)
  {
    AppMethodBeat.i(36206);
    this.rdw.put(parambcs.Id, Integer.valueOf(3));
    AppMethodBeat.o(36206);
  }
  
  public final boolean B(bcs parambcs)
  {
    AppMethodBeat.i(36215);
    if ((parambcs == null) || (parambcs.Id == null) || (parambcs.Id.equals("")))
    {
      AppMethodBeat.o(36215);
      return false;
    }
    if (com.tencent.mm.vfs.e.cN(ao.gl(ag.getAccSnsPath(), parambcs.Id) + i.f(parambcs)))
    {
      AppMethodBeat.o(36215);
      return true;
    }
    if (com.tencent.mm.vfs.e.cN(ao.gl(ag.getAccSnsPath(), parambcs.Id) + i.e(parambcs)))
    {
      AppMethodBeat.o(36215);
      return true;
    }
    parambcs = i.bc(1, parambcs.Id);
    boolean bool = i.b((com.tencent.mm.memory.n)this.rdp.get(parambcs));
    AppMethodBeat.o(36215);
    return bool;
  }
  
  public final int a(com.tencent.mm.plugin.sns.storage.n paramn, int[] paramArrayOfInt)
  {
    int j = 5;
    AppMethodBeat.i(36196);
    Object localObject;
    PInt localPInt1;
    PInt localPInt2;
    if ((paramArrayOfInt != null) || (bo.av(this.rdz) > 60000L))
    {
      localObject = new PInt();
      localPInt1 = new PInt();
      localPInt2 = new PInt();
      c.afT();
      if (!c.a((PInt)localObject, localPInt1, localPInt2)) {
        break label149;
      }
      this.rdB = 5;
      if (paramArrayOfInt != null) {
        if (((PInt)localObject).value != 0) {
          break label158;
        }
      }
    }
    label149:
    label158:
    for (int i = 0;; i = 1)
    {
      paramArrayOfInt[0] = i;
      paramArrayOfInt[1] = localPInt1.value;
      paramArrayOfInt[2] = localPInt2.value;
      this.rdC = ((PInt)localObject).value;
      this.rdz = bo.yB();
      if ((this.rdC != 0) && (paramn != null)) {
        break label163;
      }
      i = this.rdB;
      AppMethodBeat.o(36196);
      return i;
      this.rdB = 10;
      break;
    }
    label163:
    if (this.rdD.containsKey(Long.valueOf(paramn.field_snsId)))
    {
      i = ((Integer)this.rdD.get(Long.valueOf(paramn.field_snsId))).intValue();
      AppMethodBeat.o(36196);
      return i;
    }
    paramArrayOfInt = new cel();
    try
    {
      localObject = (SnsObject)new SnsObject().parseFrom(paramn.field_attrBuf);
      if (((SnsObject)localObject).ObjectOperations == null)
      {
        i = this.rdB;
        AppMethodBeat.o(36196);
        return i;
      }
      paramArrayOfInt.parseFrom(((SnsObject)localObject).ObjectOperations.getBufferToBytes());
      if ((paramArrayOfInt.xOP == null) || (paramArrayOfInt.xOP.info == null))
      {
        i = this.rdB;
        AppMethodBeat.o(36196);
        return i;
      }
    }
    catch (Exception paramn)
    {
      ab.printErrStackTrace("MicroMsg.LazyerImageLoader2", paramn, "", new Object[0]);
      i = this.rdB;
      AppMethodBeat.o(36196);
      return i;
    }
    paramArrayOfInt = paramArrayOfInt.xOP.info;
    i = paramArrayOfInt.hashCode();
    if (this.rdC == 1)
    {
      if (!this.rdF.containsKey(Integer.valueOf(i))) {
        this.rdF.put(Integer.valueOf(i), Boolean.valueOf(dj(paramArrayOfInt, this.rdC)));
      }
      if (((Boolean)this.rdF.get(Integer.valueOf(i))).booleanValue()) {}
      for (i = 5;; i = 10)
      {
        ab.i("MicroMsg.LazyerImageLoader2", "isAutoDownload(sight_autodownload) snsID:%d, result:%d", new Object[] { Long.valueOf(paramn.field_snsId), Integer.valueOf(i) });
        this.rdD.put(Long.valueOf(paramn.field_snsId), Integer.valueOf(i));
        AppMethodBeat.o(36196);
        return i;
      }
    }
    if (!this.rdE.containsKey(Integer.valueOf(i))) {
      this.rdE.put(Integer.valueOf(i), Boolean.valueOf(dj(paramArrayOfInt, this.rdC)));
    }
    if (((Boolean)this.rdE.get(Integer.valueOf(i))).booleanValue()) {}
    for (i = j;; i = 10) {
      break;
    }
  }
  
  public final Bitmap a(bcs parambcs, View paramView, int paramInt, az paramaz, boolean paramBoolean)
  {
    AppMethodBeat.i(36161);
    parambcs = a(parambcs, paramView, paramInt, true, paramaz, paramBoolean);
    AppMethodBeat.o(36161);
    return parambcs;
  }
  
  public final Bitmap a(bcs parambcs, View paramView, int paramInt, boolean paramBoolean1, az paramaz, boolean paramBoolean2)
  {
    AppMethodBeat.i(36218);
    if ((parambcs == null) || (parambcs.Id == null) || (parambcs.Id.equals("")))
    {
      AppMethodBeat.o(36218);
      return null;
    }
    String str = i.bc(3, parambcs.Id);
    Object localObject1 = C(parambcs);
    int j = -1;
    int k = -1;
    int i = j;
    try
    {
      localObject2 = d.aoT((String)localObject1);
      i = j;
      j = ((BitmapFactory.Options)localObject2).outWidth;
      i = j;
      int m = ((BitmapFactory.Options)localObject2).outHeight;
      k = m;
      i = j;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label101:
      boolean bool;
      break label101;
    }
    a(paramView, str, false, -1, paramInt, i, k, g.a.rea);
    if (ag.cpa().aac(parambcs.Id))
    {
      AppMethodBeat.o(36218);
      return null;
    }
    paramView = this.rdq;
    localObject2 = (am.b)paramView.rhX.get(str);
    if (localObject2 == null)
    {
      paramView = null;
      paramView = (WeakReference)paramView;
      localObject2 = new StringBuilder("getFromWeakReference ").append(str).append("  ");
      if (paramView != null) {
        break label264;
      }
      bool = true;
      label202:
      ab.i("MicroMsg.LazyerImageLoader2", bool);
      if (paramView != null) {
        break label270;
      }
    }
    label264:
    label270:
    for (paramView = null;; paramView = (Bitmap)paramView.get())
    {
      if (!i.A(paramView)) {
        break label281;
      }
      AppMethodBeat.o(36218);
      return paramView;
      ((am.b)paramView.rhX.get(str)).cpB();
      paramView = ((am.b)localObject2).obj;
      break;
      bool = false;
      break label202;
    }
    label281:
    if (parambcs.Id.startsWith("pre_temp_extend_pic"))
    {
      paramView = s.abM((String)localObject1);
      localObject1 = this.rdq;
      localObject2 = new WeakReference(paramView);
      if ((am.b)((am)localObject1).rhX.get(str) != null) {
        break label391;
      }
      localObject2 = new am.b((am)localObject1, localObject2);
      ((am)localObject1).rhX.put(str, localObject2);
      ((am)localObject1).cpA();
    }
    for (;;)
    {
      if (!i.A(paramView)) {
        break label432;
      }
      AppMethodBeat.o(36218);
      return paramView;
      paramView = i.ZG((String)localObject1);
      break;
      label391:
      ((am.b)((am)localObject1).rhX.get(str)).cpB();
      ((am.b)((am)localObject1).rhX.get(str)).obj = localObject2;
    }
    label432:
    if (paramBoolean1)
    {
      paramView = ag.cpa();
      if (!paramBoolean2) {
        break label467;
      }
    }
    label467:
    for (paramInt = 8;; paramInt = 2)
    {
      paramView.a(parambcs, paramInt, null, paramaz);
      AppMethodBeat.o(36218);
      return null;
    }
  }
  
  public final com.tencent.mm.memory.n a(bcs parambcs, ImageView paramImageView, int paramInt, az paramaz)
  {
    AppMethodBeat.i(36219);
    if ((parambcs == null) || (parambcs.Id == null) || (parambcs.Id.equals("")))
    {
      AppMethodBeat.o(36219);
      return null;
    }
    paramImageView.setDrawingCacheEnabled(false);
    String str = i.bc(0, parambcs.Id);
    a(paramImageView, str, -1, paramInt);
    paramImageView = aaj(str);
    if (!i.b(paramImageView))
    {
      a(0, parambcs, paramaz);
      AppMethodBeat.o(36219);
      return null;
    }
    AppMethodBeat.o(36219);
    return paramImageView;
  }
  
  public final String a(bcs parambcs)
  {
    AppMethodBeat.i(36166);
    String str = ao.gl(ag.getAccSnsPath(), parambcs.Id);
    parambcs = i.e(parambcs);
    parambcs = str + parambcs;
    AppMethodBeat.o(36166);
    return parambcs;
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(36220);
    a(paramView, null, true, -1, paramInt3, -1, -1, g.a.rea);
    if (paramInt1 != -1) {
      paramView.setBackgroundResource(paramInt1);
    }
    if (paramInt2 != -1)
    {
      if ((paramView instanceof QFadeImageView))
      {
        ((QFadeImageView)paramView).setImageResource(paramInt2);
        AppMethodBeat.o(36220);
        return;
      }
      if ((paramView instanceof ImageView))
      {
        ((ImageView)paramView).setImageDrawable(com.tencent.mm.cb.a.k(paramView.getContext(), paramInt2));
        AppMethodBeat.o(36220);
      }
    }
    else
    {
      if ((paramView instanceof QFadeImageView))
      {
        ((QFadeImageView)paramView).setImageResource(2130838904);
        AppMethodBeat.o(36220);
        return;
      }
      if ((paramView instanceof ImageView)) {
        ((ImageView)paramView).setImageResource(2130838904);
      }
    }
    AppMethodBeat.o(36220);
  }
  
  public final void a(bcs parambcs, View paramView, int paramInt1, int paramInt2, g.a parama, az paramaz)
  {
    AppMethodBeat.i(36173);
    if ((parambcs == null) || (parambcs.Id == null) || (parambcs.Id.equals("")))
    {
      AppMethodBeat.o(36173);
      return;
    }
    paramView.setDrawingCacheEnabled(false);
    String str = i.bc(0, parambcs.Id);
    a(paramView, str, paramInt1, paramInt2, parama);
    parama = aaj(str);
    if (!i.b(parama))
    {
      ab.d("MicroMsg.LazyerImageLoader2", "setSnsGrid cache miss");
      if (paramInt1 == -1) {
        dD(paramView);
      }
      if (this.rdJ.contains(str))
      {
        AppMethodBeat.o(36173);
        return;
      }
      a(0, parambcs, paramaz);
      AppMethodBeat.o(36173);
      return;
    }
    ab.d("MicroMsg.LazyerImageLoader2", "setSnsGrid cache hit");
    ag.cpa().aag(parambcs.Id);
    a(paramView, str, parama);
    AppMethodBeat.o(36173);
  }
  
  public final void a(bcs parambcs, View paramView, int paramInt1, int paramInt2, az paramaz)
  {
    AppMethodBeat.i(36171);
    a(parambcs, paramView, paramInt1, paramInt2, g.a.rea, paramaz);
    AppMethodBeat.o(36171);
  }
  
  public final void a(bcs parambcs, View paramView, int paramInt, g.a parama, az paramaz)
  {
    AppMethodBeat.i(36168);
    a(parambcs, paramView, -1, paramInt, parama, paramaz);
    AppMethodBeat.o(36168);
  }
  
  public final void a(bcs parambcs, View paramView, int paramInt, az paramaz)
  {
    AppMethodBeat.i(36178);
    b(parambcs, paramView, -1, paramInt, paramaz);
    AppMethodBeat.o(36178);
  }
  
  public final void a(String paramString, SparseArray<bcs> paramSparseArray, SparseArray<View> paramSparseArray1, int paramInt1, az paramaz, int paramInt2)
  {
    AppMethodBeat.i(145245);
    ab.i("MicroMsg.LazyerImageLoader2", "enter group img download logic!");
    if ((paramSparseArray == null) || (paramSparseArray.size() <= 0))
    {
      ab.e("MicroMsg.LazyerImageLoader2", "setSnsMultiImg check params, medias is invalid.");
      AppMethodBeat.o(145245);
      return;
    }
    if ((paramSparseArray1 == null) || (paramSparseArray1.size() <= 0))
    {
      ab.e("MicroMsg.LazyerImageLoader2", "setSnsMultiImg check params, imageViews is invalid.");
      AppMethodBeat.o(145245);
      return;
    }
    int j = paramSparseArray.size();
    int k = paramSparseArray1.size();
    if (j == k) {}
    for (int i = j; -1 == i; i = -1)
    {
      ab.e("MicroMsg.LazyerImageLoader2", "setSnsMultiImg check params, mediaSize(%d) != imgViewSize(%d).", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
      AppMethodBeat.o(145245);
      return;
    }
    SparseArray localSparseArray1 = new SparseArray();
    SparseArray localSparseArray2 = new SparseArray();
    SparseArray localSparseArray3 = new SparseArray();
    i = 0;
    if (i < j)
    {
      k = paramSparseArray.keyAt(i);
      bcs localbcs = (bcs)paramSparseArray.get(k);
      View localView = (View)paramSparseArray1.get(k);
      localView.setDrawingCacheEnabled(false);
      String str = i.bc(0, localbcs.Id);
      a(localView, str, -1, paramInt1, g.a.rea);
      com.tencent.mm.memory.n localn = aaj(str);
      if (!i.b(localn))
      {
        ab.i("MicroMsg.LazyerImageLoader2", "setSnsMultiImg, cache miss.");
        dD(localView);
        if (this.rdJ.contains(str))
        {
          AppMethodBeat.o(145245);
          return;
        }
        localSparseArray1.put(k, localbcs);
      }
      for (;;)
      {
        i += 1;
        break;
        ab.i("MicroMsg.LazyerImageLoader2", "setSnsMultiImg, cache hit.");
        a(localView, str, localn);
      }
    }
    ag.coS().execute(new g.6(this, localSparseArray1, localSparseArray2, localSparseArray3, paramString, paramaz, paramInt2));
    AppMethodBeat.o(145245);
  }
  
  public final void a(List<bcs> paramList, View paramView, int paramInt, g.a parama, az paramaz)
  {
    AppMethodBeat.i(36221);
    a(paramList, paramView, paramInt, parama, paramaz, false);
    AppMethodBeat.o(36221);
  }
  
  public final void a(List<bcs> paramList, View paramView, int paramInt, g.a parama, az paramaz, boolean paramBoolean)
  {
    AppMethodBeat.i(36222);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(36222);
      return;
    }
    if (paramList.size() == 1)
    {
      if (!paramBoolean)
      {
        b((bcs)paramList.get(0), paramView, paramInt, paramaz);
        AppMethodBeat.o(36222);
        return;
      }
      b((bcs)paramList.get(0), paramView, paramInt, g.a.reb, paramaz);
      AppMethodBeat.o(36222);
      return;
    }
    String str = i.bc(0, i.cY(paramList));
    a(paramView, str, paramInt, parama);
    parama = aaj(str);
    paramBoolean = i.b(parama);
    ab.v("MicroMsg.LazyerImageLoader2", "set Sns GridList ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean)
    {
      dD(paramView);
      if (this.rdJ.contains(str))
      {
        AppMethodBeat.o(36222);
        return;
      }
      new WeakReference(paramView);
      a(paramList, paramaz);
      AppMethodBeat.o(36222);
      return;
    }
    a(paramView, str, parama);
    AppMethodBeat.o(36222);
  }
  
  public final boolean a(com.tencent.mm.plugin.sight.decode.a.a parama, int paramInt)
  {
    AppMethodBeat.i(36179);
    a(parama, "", -1, paramInt);
    parama.setThumbBmp(null);
    parama.bl(null, false);
    AppMethodBeat.o(36179);
    return true;
  }
  
  public final boolean a(com.tencent.mm.plugin.sns.data.e parame, String paramString)
  {
    AppMethodBeat.i(36211);
    Object localObject1 = (bcs)parame.list.get(0);
    int i = 1;
    Object localObject2;
    if (i < parame.list.size())
    {
      localObject2 = (bcs)parame.list.get(i);
      if ((paramString != null) && (paramString.indexOf(((bcs)localObject2).Id) >= 0)) {
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject2 = ao.gl(ag.getAccSnsPath(), ((bcs)localObject1).Id);
      if (parame.rbj == 0) {
        paramString = i.f((bcs)localObject1);
      }
      for (;;)
      {
        String str = i.bc(parame.rbj, ((bcs)localObject1).Id);
        if (!this.rdp.Z(str)) {
          new g.b(this, i.bc(parame.rbj, ((bcs)localObject1).Id), (String)localObject2 + paramString, (String)localObject2, (bcs)localObject1, parame.rbj).v(new String[] { "" });
        }
        AppMethodBeat.o(36211);
        return true;
        i += 1;
        break;
        if (parame.rbj == 4) {
          paramString = i.g((bcs)localObject1);
        } else if (parame.rbj == 5) {
          paramString = i.g((bcs)localObject1);
        } else if (parame.rbj == 3) {
          paramString = i.l((bcs)localObject1);
        } else {
          paramString = i.e((bcs)localObject1);
        }
      }
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.sns.storage.n paramn, bcs parambcs, com.tencent.mm.plugin.sight.decode.a.a parama, int paramInt1, int paramInt2, az paramaz, boolean paramBoolean)
  {
    AppMethodBeat.i(36180);
    paramBoolean = a(paramn, parambcs, parama, paramInt1, paramInt2, paramaz, paramBoolean, false);
    AppMethodBeat.o(36180);
    return paramBoolean;
  }
  
  public final boolean a(com.tencent.mm.plugin.sns.storage.n paramn, bcs parambcs, com.tencent.mm.plugin.sight.decode.a.a parama, int paramInt1, int paramInt2, az paramaz, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(36181);
    if ((parambcs == null) || (parambcs.Id == null) || (parambcs.Id.equals("")))
    {
      AppMethodBeat.o(36181);
      return false;
    }
    String str1 = i.bc(1, parambcs.Id);
    a(parama, str1, -1, paramInt1);
    String str2 = ao.gl(ag.getAccSnsPath(), parambcs.Id);
    String str3 = i.e(parambcs);
    Object localObject;
    if (!com.tencent.mm.vfs.e.cN(str2 + str3))
    {
      localObject = new com.tencent.mm.plugin.sns.data.e(parambcs);
      ((com.tencent.mm.plugin.sns.data.e)localObject).rbj = 1;
      ((com.tencent.mm.plugin.sns.data.e)localObject).ohe = parambcs.Id;
      b localb = ag.cpa();
      if (parambcs.jKs == 6)
      {
        paramInt1 = 5;
        localb.a(parambcs, paramInt1, (com.tencent.mm.plugin.sns.data.e)localObject, paramaz);
      }
    }
    else
    {
      localObject = "";
      if (paramBoolean1) {
        localObject = a(paramn, parambcs, paramaz, paramBoolean1);
      }
      ab.i("MicroMsg.LazyerImageLoader2", "setsight %s sightPath %s isAd %b", new Object[] { str1, localObject, Boolean.valueOf(paramBoolean1) });
      if ((bo.isNullOrNil((String)localObject)) || (u(parambcs))) {
        break label328;
      }
      if (!((String)localObject).equals(parama.getVideoPath()))
      {
        if (!paramBoolean2) {
          break label317;
        }
        paramn = BitmapFactory.decodeFile(str2 + str3);
        label268:
        parama.setThumbBmp(paramn);
      }
      if (this.rdd) {
        break label322;
      }
    }
    label317:
    label322:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      parama.bl((String)localObject, paramBoolean1);
      parama.setPosition(paramInt2);
      AppMethodBeat.o(36181);
      return true;
      paramInt1 = 1;
      break;
      paramn = null;
      break label268;
    }
    label328:
    ab.i("MicroMsg.LazyerImageLoader2", "sightPath %s", new Object[] { localObject });
    if (!this.rdd)
    {
      paramBoolean1 = true;
      parama.bl(null, paramBoolean1);
      paramn = aaj(str1);
      paramBoolean1 = i.b(paramn);
      ab.v("MicroMsg.LazyerImageLoader2", "setsight thumb  %s", new Object[] { Boolean.valueOf(paramBoolean1) });
      if (paramBoolean1) {
        break label517;
      }
      if ((!(parama instanceof ImageView)) && (!(parama instanceof QFadeImageView))) {
        break label451;
      }
      dD((View)parama);
    }
    for (;;)
    {
      if (this.rdJ.contains(str1))
      {
        AppMethodBeat.o(36181);
        return false;
        paramBoolean1 = false;
        break;
        label451:
        if ((parama instanceof com.tencent.mm.plugin.sight.decode.a.a))
        {
          if (!this.rdd) {}
          for (paramBoolean1 = true;; paramBoolean1 = false)
          {
            parama.bl(null, paramBoolean1);
            parama.setPosition(0);
            parama.setThumbBmp(null);
            break;
          }
        }
      }
    }
    a(1, parambcs, paramaz);
    AppMethodBeat.o(36181);
    return false;
    label517:
    a(parama, str1, paramn);
    AppMethodBeat.o(36181);
    return true;
  }
  
  public final boolean a(bcs parambcs, View paramView, int paramInt1, int paramInt2, az paramaz, int paramInt3)
  {
    AppMethodBeat.i(36184);
    if ((parambcs == null) || (parambcs.Id == null) || (parambcs.Id.equals("")))
    {
      AppMethodBeat.o(36184);
      return false;
    }
    String str = i.bc(paramInt3, parambcs.Id);
    a(paramView, str, paramInt1, paramInt2);
    com.tencent.mm.memory.n localn = aaj(str);
    boolean bool = i.b(localn);
    ab.v("MicroMsg.LazyerImageLoader2", "set sns Thumb  " + bool + " " + str);
    if (!bool)
    {
      if (paramInt1 == -1) {
        dD(paramView);
      }
      if (this.rdJ.contains(str))
      {
        AppMethodBeat.o(36184);
        return true;
      }
      a(paramInt3, parambcs, paramaz);
      AppMethodBeat.o(36184);
      return false;
    }
    a(paramView, str, localn);
    AppMethodBeat.o(36184);
    return true;
  }
  
  public final boolean a(String paramString, com.tencent.mm.memory.n paramn, int paramInt)
  {
    AppMethodBeat.i(36209);
    a(paramInt + "-" + paramString, paramn);
    AppMethodBeat.o(36209);
    return true;
  }
  
  public final com.tencent.mm.memory.n aaj(String paramString)
  {
    AppMethodBeat.i(36169);
    com.tencent.mm.memory.n localn = (com.tencent.mm.memory.n)this.rdp.get(paramString);
    if ((localn == null) || (localn.isRecycled()))
    {
      this.rdp.remove(paramString);
      AppMethodBeat.o(36169);
      return null;
    }
    AppMethodBeat.o(36169);
    return localn;
  }
  
  public final void aal(String paramString)
  {
    AppMethodBeat.i(36212);
    b(paramString, null);
    AppMethodBeat.o(36212);
  }
  
  public final com.tencent.mm.memory.n aam(String paramString)
  {
    AppMethodBeat.i(36213);
    if (this.rdp == null)
    {
      AppMethodBeat.o(36213);
      return null;
    }
    paramString = (com.tencent.mm.memory.n)this.rdp.get("0-".concat(String.valueOf(paramString)));
    AppMethodBeat.o(36213);
    return paramString;
  }
  
  public final void ah(Activity paramActivity)
  {
    AppMethodBeat.i(36163);
    ab.d("MicroMsg.LazyerImageLoader2", "try to remove ImageView " + this.fEx.size());
    Object localObject1 = new LinkedList();
    Object localObject2 = this.rdv.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (g.c)((Iterator)localObject2).next();
      if (ag(paramActivity.getWindow().getDecorView(), ((g.c)localObject3).code)) {
        ((List)localObject1).add(Integer.valueOf(((g.c)localObject3).code));
      }
    }
    localObject2 = ((List)localObject1).iterator();
    int i;
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label211;
      }
      i = ((Integer)((Iterator)localObject2).next()).intValue();
      this.fEx.remove(Integer.valueOf(i));
      localObject3 = this.rdv.iterator();
      if (((Iterator)localObject3).hasNext())
      {
        g.c localc = (g.c)((Iterator)localObject3).next();
        if (localc.code != i) {
          break;
        }
        this.rdv.remove(localc);
      }
    }
    label211:
    ((List)localObject1).clear();
    localObject2 = this.rdv.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (g.c)((Iterator)localObject2).next();
      if (((g.c)localObject3).reg == paramActivity.hashCode()) {
        ((List)localObject1).add(Integer.valueOf(((g.c)localObject3).code));
      }
    }
    paramActivity = ((List)localObject1).iterator();
    for (;;)
    {
      if (!paramActivity.hasNext()) {
        break label371;
      }
      i = ((Integer)paramActivity.next()).intValue();
      this.fEx.remove(Integer.valueOf(i));
      localObject1 = this.rdv.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (g.c)((Iterator)localObject1).next();
        if (((g.c)localObject2).code != i) {
          break;
        }
        this.rdv.remove(localObject2);
      }
    }
    label371:
    this.rdq.cpA();
    ab.d("MicroMsg.LazyerImageLoader2", "after try to remove ImageView " + this.fEx.size());
    AppMethodBeat.o(36163);
  }
  
  public final int b(com.tencent.mm.plugin.sns.storage.n paramn, int[] paramArrayOfInt)
  {
    int j = 5;
    AppMethodBeat.i(36198);
    Object localObject;
    PInt localPInt;
    if ((paramArrayOfInt != null) || (bo.av(this.rdA) > 60000L))
    {
      localObject = new PInt();
      localPInt = new PInt();
      c.afT();
      if (!c.a((PInt)localObject, localPInt)) {
        break label130;
      }
      this.rdG = 5;
      if (paramArrayOfInt != null) {
        if (((PInt)localObject).value != 0) {
          break label139;
        }
      }
    }
    label130:
    label139:
    for (int i = 0;; i = 1)
    {
      paramArrayOfInt[0] = i;
      paramArrayOfInt[1] = localPInt.value;
      this.rdH = ((PInt)localObject).value;
      this.rdA = bo.yB();
      if ((this.rdH != 0) && (paramn != null)) {
        break label144;
      }
      i = this.rdG;
      AppMethodBeat.o(36198);
      return i;
      this.rdG = 10;
      break;
    }
    label144:
    if (this.rdI.containsKey(Long.valueOf(paramn.field_snsId)))
    {
      i = ((Integer)this.rdI.get(Long.valueOf(paramn.field_snsId))).intValue();
      AppMethodBeat.o(36198);
      return i;
    }
    paramArrayOfInt = new cel();
    try
    {
      localObject = (SnsObject)new SnsObject().parseFrom(paramn.field_attrBuf);
      if (((SnsObject)localObject).ObjectOperations == null)
      {
        i = this.rdG;
        AppMethodBeat.o(36198);
        return i;
      }
      paramArrayOfInt.parseFrom(((SnsObject)localObject).ObjectOperations.getBufferToBytes());
      if ((paramArrayOfInt.xOP == null) || (paramArrayOfInt.xOP.info == null))
      {
        i = this.rdB;
        AppMethodBeat.o(36198);
        return i;
      }
    }
    catch (Exception paramn)
    {
      ab.printErrStackTrace("MicroMsg.LazyerImageLoader2", paramn, "", new Object[0]);
      i = this.rdG;
      AppMethodBeat.o(36198);
      return i;
    }
    paramArrayOfInt = paramArrayOfInt.xOP.info;
    i = paramArrayOfInt.hashCode();
    if (this.rdH == 1)
    {
      if (!this.rdF.containsKey(Integer.valueOf(i))) {
        this.rdF.put(Integer.valueOf(i), Boolean.valueOf(dj(paramArrayOfInt, this.rdH)));
      }
      if (((Boolean)this.rdF.get(Integer.valueOf(i))).booleanValue()) {}
      for (i = 5;; i = 10)
      {
        ab.i("MicroMsg.LazyerImageLoader2", "isAutoAdDownload(sight_autodownload) snsID:%d, result:%d", new Object[] { Long.valueOf(paramn.field_snsId), Integer.valueOf(i) });
        this.rdI.put(Long.valueOf(paramn.field_snsId), Integer.valueOf(i));
        AppMethodBeat.o(36198);
        return i;
      }
    }
    if (!this.rdE.containsKey(Integer.valueOf(i))) {
      this.rdE.put(Integer.valueOf(i), Boolean.valueOf(dj(paramArrayOfInt, this.rdH)));
    }
    if (((Boolean)this.rdE.get(Integer.valueOf(i))).booleanValue()) {}
    for (i = j;; i = 10) {
      break;
    }
  }
  
  public final Bitmap b(bcs parambcs)
  {
    AppMethodBeat.i(36165);
    if ((parambcs == null) || (parambcs.Id == null) || (parambcs.Id.equals("")))
    {
      AppMethodBeat.o(36165);
      return null;
    }
    String str1 = i.bc(1, parambcs.Id);
    Object localObject = aaj(str1);
    if (i.b((com.tencent.mm.memory.n)localObject))
    {
      parambcs = ((com.tencent.mm.memory.n)localObject).XS();
      AppMethodBeat.o(36165);
      return parambcs;
    }
    localObject = ao.gl(ag.getAccSnsPath(), parambcs.Id);
    String str2 = i.e(parambcs);
    localObject = (String)localObject + str2;
    if (com.tencent.mm.vfs.e.cN((String)localObject))
    {
      if (parambcs.Id.startsWith("pre_temp_extend_pic")) {}
      for (parambcs = com.tencent.mm.memory.n.v(s.abM((String)localObject)); i.b(parambcs); parambcs = i.ZH((String)localObject))
      {
        a(str1, parambcs);
        parambcs = parambcs.XS();
        AppMethodBeat.o(36165);
        return parambcs;
      }
      AppMethodBeat.o(36165);
      return null;
    }
    AppMethodBeat.o(36165);
    return null;
  }
  
  public final void b(bcs parambcs, View paramView, int paramInt, az paramaz)
  {
    AppMethodBeat.i(36167);
    a(parambcs, paramView, -1, paramInt, paramaz);
    AppMethodBeat.o(36167);
  }
  
  protected final void b(String paramString, com.tencent.mm.memory.n paramn)
  {
    AppMethodBeat.i(36223);
    com.tencent.mm.memory.n localn = paramn;
    if (!i.b(paramn)) {
      localn = aak(paramString);
    }
    if (i.b(localn))
    {
      if ((this.rdp != null) && (localn != null) && (paramString != null)) {
        this.rdp.put(paramString, localn);
      }
      paramn = (LinkedList)this.rdr.get(paramString);
      if (paramn != null)
      {
        paramn = paramn.iterator();
        while (paramn.hasNext())
        {
          Object localObject = (g.c)((WeakReference)paramn.next()).get();
          if ((localObject != null) && (((g.c)localObject).reh) && (paramString != null) && (paramString.equals(((g.c)localObject).id)))
          {
            int i = ((g.c)localObject).code;
            localObject = (WeakReference)this.fEx.get(Integer.valueOf(i));
            if (localObject != null)
            {
              localObject = ((WeakReference)localObject).get();
              if (localObject != null)
              {
                if ((localObject instanceof QFadeImageView))
                {
                  QFadeImageView localQFadeImageView = (QFadeImageView)localObject;
                  if ((this.rdy != null) && ((localQFadeImageView instanceof TagImageView)))
                  {
                    i = ((TagImageView)localQFadeImageView).getPosition();
                    if ((i != -1) && (!this.rdy.EF(i))) {
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
                    label266:
                    if (localObject != null) {
                      break label322;
                    }
                  }
                  label322:
                  for (boolean bool2 = true;; bool2 = false)
                  {
                    ab.d("MicroMsg.LazyerImageLoader2", "setRefImageView null bmNUll: %s ivNull: %s bimapavailable %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(i.b(localn)) });
                    break;
                    bool1 = false;
                    break label266;
                  }
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(36223);
  }
  
  public final boolean b(bcs parambcs, View paramView, int paramInt1, int paramInt2, az paramaz)
  {
    AppMethodBeat.i(36183);
    boolean bool = a(parambcs, paramView, paramInt1, paramInt2, paramaz, 1);
    AppMethodBeat.o(36183);
    return bool;
  }
  
  public final void c(bcs parambcs, View paramView, int paramInt, az paramaz)
  {
    AppMethodBeat.i(36182);
    if ((parambcs == null) || (parambcs.Id == null) || (parambcs.Id.equals("")))
    {
      AppMethodBeat.o(36182);
      return;
    }
    String str = i.bc(4, parambcs.Id);
    a(paramView, str, -1, paramInt);
    com.tencent.mm.memory.n localn = aaj(str);
    boolean bool = i.b(localn);
    ab.v("MicroMsg.LazyerImageLoader2", "set sns Thumb  ".concat(String.valueOf(bool)));
    if (!bool)
    {
      dD(paramView);
      if (!this.rdJ.contains(str))
      {
        a(4, parambcs, paramaz);
        AppMethodBeat.o(36182);
      }
    }
    else
    {
      a(paramView, str, localn);
    }
    AppMethodBeat.o(36182);
  }
  
  public final void cnM()
  {
    AppMethodBeat.i(36224);
    cow();
    this.rdz = 0L;
    this.rdA = 0L;
    this.rdt.clear();
    this.rdu = false;
    AppMethodBeat.o(36224);
  }
  
  public final void cow()
  {
    AppMethodBeat.i(36160);
    if (this.rdp != null)
    {
      this.fEx.clear();
      this.rdq.rhX.clear();
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("mMemoryCache \n");
      localStringBuffer.append("putCount:" + this.rdp.putCount() + ";");
      localStringBuffer.append("missCount:" + this.rdp.missCount() + ";");
      localStringBuffer.append("hitCount:" + this.rdp.hitCount() + ";");
      localStringBuffer.append("createCount:" + this.rdp.createCount() + ";");
      localStringBuffer.append("evictionCount:" + this.rdp.evictionCount() + ";");
      ab.i("MicroMsg.LazyerImageLoader2", "report lurcache ");
      this.rdp.trimToSize(-1);
    }
    this.rdq.cpA();
    System.gc();
    AppMethodBeat.o(36160);
  }
  
  public final void dC(View paramView)
  {
    AppMethodBeat.i(36164);
    if ((paramView instanceof ImageView))
    {
      ((ImageView)paramView).setImageBitmap(null);
      AppMethodBeat.o(36164);
      return;
    }
    if ((paramView instanceof QImageView))
    {
      ((QImageView)paramView).setImageBitmap(null);
      AppMethodBeat.o(36164);
      return;
    }
    AppMethodBeat.o(36164);
  }
  
  public final boolean dE(View paramView)
  {
    AppMethodBeat.i(36190);
    int i = paramView.hashCode();
    paramView = this.rdv.iterator();
    while (paramView.hasNext())
    {
      g.c localc = (g.c)paramView.next();
      if (i == localc.code) {
        this.rdv.remove(localc);
      }
    }
    this.fEx.remove(Integer.valueOf(i));
    AppMethodBeat.o(36190);
    return true;
  }
  
  public final boolean gj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(36208);
    if ((this.rdw.containsKey(paramString1)) && (3 == ((Integer)this.rdw.get(paramString1)).intValue())) {
      this.rdw.remove(paramString1);
    }
    String str = i.bc(1, paramString1);
    Object localObject1 = (LinkedList)this.rdr.get(str);
    if (localObject1 == null)
    {
      AppMethodBeat.o(36208);
      return false;
    }
    localObject1 = ((LinkedList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (g.c)((WeakReference)((Iterator)localObject1).next()).get();
      if ((localObject2 != null) && (((g.c)localObject2).reh) && (str != null) && (str.equals(((g.c)localObject2).id)))
      {
        int i = ((g.c)localObject2).code;
        localObject2 = (WeakReference)this.fEx.get(Integer.valueOf(i));
        if (localObject2 != null)
        {
          localObject2 = ((WeakReference)localObject2).get();
          if ((localObject2 != null) && ((localObject2 instanceof com.tencent.mm.plugin.sight.decode.a.a)))
          {
            ab.i("MicroMsg.LazyerImageLoader2", "download fin set sight %s %s", new Object[] { paramString1, paramString2 });
            localObject2 = (com.tencent.mm.plugin.sight.decode.a.a)localObject2;
            if ((((com.tencent.mm.plugin.sight.decode.a.a)localObject2).getTagObject() instanceof com.tencent.mm.plugin.sns.ui.aj))
            {
              com.tencent.mm.plugin.sns.ui.aj localaj = (com.tencent.mm.plugin.sns.ui.aj)((com.tencent.mm.plugin.sight.decode.a.a)localObject2).getTagObject();
              boolean bool;
              if (localaj != null)
              {
                if (com.tencent.mm.vfs.e.cN(paramString2))
                {
                  if (!this.rdd) {}
                  for (bool = true;; bool = false)
                  {
                    ((com.tencent.mm.plugin.sight.decode.a.a)localObject2).bl(paramString2, bool);
                    ((com.tencent.mm.plugin.sight.decode.a.a)localObject2).setPosition(localaj.position);
                    localaj.rLF.setVisibility(8);
                    localaj.rwJ.setVisibility(8);
                    localaj.rwK.setVisibility(8);
                    if ((!this.rdw.containsKey(paramString1)) || (4 != ((Integer)this.rdw.get(paramString1)).intValue())) {
                      break;
                    }
                    this.rdw.remove(paramString1);
                    break;
                  }
                }
                this.rdw.put(paramString1, Integer.valueOf(4));
                localaj.rLF.setVisibility(8);
                localaj.rwJ.setImageResource(2130840321);
                localaj.rwJ.setVisibility(0);
              }
              else
              {
                if (!this.rdd) {}
                for (bool = true;; bool = false)
                {
                  ((com.tencent.mm.plugin.sight.decode.a.a)localObject2).bl(paramString2, bool);
                  break;
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(36208);
    return true;
  }
  
  public final int n(com.tencent.mm.plugin.sns.storage.n paramn)
  {
    AppMethodBeat.i(36195);
    int i = a(paramn, null);
    AppMethodBeat.o(36195);
    return i;
  }
  
  public final int o(com.tencent.mm.plugin.sns.storage.n paramn)
  {
    AppMethodBeat.i(156755);
    int i = b(paramn, null);
    AppMethodBeat.o(156755);
    return i;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(36158);
    this.rdd = false;
    b localb = ag.cpa();
    localb.rdd = false;
    Object localObject3;
    synchronized (localb.eFQ)
    {
      localObject2 = new LinkedList();
      localObject3 = localb.elu.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        com.tencent.mm.plugin.sns.data.f localf = (com.tencent.mm.plugin.sns.data.f)((Iterator)localObject3).next();
        if (localf.requestType != 6)
        {
          localb.rdg.remove(localf.key);
          ((LinkedList)localObject2).add(localf);
        }
      }
    }
    Object localObject2 = ((LinkedList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (com.tencent.mm.plugin.sns.data.f)((Iterator)localObject2).next();
      localObject1.elu.remove(localObject3);
    }
    AppMethodBeat.o(36158);
  }
  
  public final void start()
  {
    AppMethodBeat.i(36157);
    this.rdd = true;
    cox();
    b localb = ag.cpa();
    localb.rdd = true;
    localb.ahb();
    AppMethodBeat.o(36157);
  }
  
  public final boolean u(bcs parambcs)
  {
    AppMethodBeat.i(36200);
    if (!this.rdw.containsKey(parambcs.Id))
    {
      AppMethodBeat.o(36200);
      return false;
    }
    if (((Integer)this.rdw.get(parambcs.Id)).intValue() == 1)
    {
      AppMethodBeat.o(36200);
      return true;
    }
    AppMethodBeat.o(36200);
    return false;
  }
  
  public final boolean v(bcs parambcs)
  {
    AppMethodBeat.i(36201);
    if (!this.rdw.containsKey(parambcs.Id))
    {
      AppMethodBeat.o(36201);
      return false;
    }
    if (((Integer)this.rdw.get(parambcs.Id)).intValue() == 2)
    {
      AppMethodBeat.o(36201);
      return true;
    }
    AppMethodBeat.o(36201);
    return false;
  }
  
  public final boolean w(bcs parambcs)
  {
    AppMethodBeat.i(36202);
    if (!this.rdw.containsKey(parambcs.Id))
    {
      AppMethodBeat.o(36202);
      return false;
    }
    if (((Integer)this.rdw.get(parambcs.Id)).intValue() == 3)
    {
      AppMethodBeat.o(36202);
      return true;
    }
    AppMethodBeat.o(36202);
    return false;
  }
  
  public final boolean x(bcs parambcs)
  {
    AppMethodBeat.i(36203);
    if (!this.rdw.containsKey(parambcs.Id))
    {
      AppMethodBeat.o(36203);
      return false;
    }
    if (((Integer)this.rdw.get(parambcs.Id)).intValue() == 4)
    {
      AppMethodBeat.o(36203);
      return true;
    }
    AppMethodBeat.o(36203);
    return false;
  }
  
  public final void y(bcs parambcs)
  {
    AppMethodBeat.i(36204);
    this.rdw.put(parambcs.Id, Integer.valueOf(1));
    AppMethodBeat.o(36204);
  }
  
  public final void z(bcs parambcs)
  {
    AppMethodBeat.i(36205);
    this.rdw.put(parambcs.Id, Integer.valueOf(2));
    AppMethodBeat.o(36205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.g
 * JD-Core Version:    0.7.0.1
 */