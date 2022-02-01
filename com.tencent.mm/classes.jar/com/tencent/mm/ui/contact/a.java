package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.TextAppearanceSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ci;
import com.tencent.mm.storagebase.a.d;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.NoMeasuredTextView.c;
import com.tencent.mm.ui.chatting.view.AvatarImageView;
import com.tencent.mm.ui.f.b;
import com.tencent.mm.ui.f.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class a
  extends com.tencent.mm.ui.f<String, com.tencent.mm.storage.f>
  implements MStorageEx.IOnStorageChange
{
  public static final ColorStateList yCN;
  public static final ColorStateList yCO;
  protected MMSlideDelView.f AAA;
  private HashSet<String> PSA;
  public HashMap<String, com.tencent.mm.storage.f> PSe;
  protected String PSf;
  protected String PSg;
  private List<Object> PSh;
  private List<String> PSi;
  private int PSj;
  protected int[] PSk;
  String[] PSl;
  protected AddressUI.AddressUIFragment PSm;
  private Set<Integer> PSn;
  private int PSo;
  private boolean PSp;
  a PSq;
  private boolean PSr;
  boolean PSs;
  private String PSt;
  LinkedList<View> PSu;
  boolean PSv;
  HashMap<View, ViewStub> PSw;
  private NoMeasuredTextView.c PSx;
  private SparseArray<String> PSy;
  private SparseArray<Integer> PSz;
  private String[] Paj;
  View.OnClickListener dec;
  protected List<String> gzY;
  private WeakReference<Context> kRw;
  private String kdi;
  private com.tencent.mm.ui.applet.b kex;
  protected MMSlideDelView.g pkY;
  protected MMSlideDelView.c pkZ;
  protected MMSlideDelView.d plb;
  private boolean poG;
  StringBuilder sb;
  private int type;
  
  static
  {
    AppMethodBeat.i(37596);
    yCN = com.tencent.mm.cb.a.m(MMApplicationContext.getContext(), 2131100808);
    yCO = com.tencent.mm.cb.a.m(MMApplicationContext.getContext(), 2131100594);
    AppMethodBeat.o(37596);
  }
  
  public a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(37572);
    this.PSf = null;
    this.PSg = null;
    this.gzY = null;
    this.PSj = 0;
    this.kdi = "";
    this.Paj = null;
    this.plb = MMSlideDelView.getItemStatusCallBack();
    this.PSn = new HashSet();
    this.PSo = 0;
    this.PSp = true;
    this.kex = null;
    this.poG = false;
    this.PSr = false;
    this.PSs = false;
    this.PSu = new LinkedList();
    this.PSw = new HashMap();
    this.PSx = new NoMeasuredTextView.c()
    {
      public final CharSequence a(NoMeasuredTextView paramAnonymousNoMeasuredTextView, CharSequence paramAnonymousCharSequence, String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(233972);
        float f1 = paramAnonymousNoMeasuredTextView.getPaint().getTextSize();
        paramAnonymousInt2 = com.tencent.mm.cb.a.fromDPToPix(a.a(a.this), paramAnonymousInt2);
        paramAnonymousNoMeasuredTextView.getPaint().setTextSize(paramAnonymousInt2);
        float f2 = paramAnonymousNoMeasuredTextView.getPaint().measureText(" ".concat(String.valueOf(paramAnonymousString)));
        paramAnonymousNoMeasuredTextView.getPaint().setTextSize(f1);
        int i = paramAnonymousNoMeasuredTextView.getMeasuredWidth() - paramAnonymousNoMeasuredTextView.getCompoundPaddingRight() - paramAnonymousNoMeasuredTextView.getCompoundPaddingLeft();
        if (f2 >= i * 0.6D)
        {
          paramAnonymousCharSequence = TextUtils.ellipsize(paramAnonymousCharSequence, paramAnonymousNoMeasuredTextView.getPaint(), (float)(i * 0.4D), TextUtils.TruncateAt.END);
          f2 = paramAnonymousNoMeasuredTextView.getPaint().measureText(paramAnonymousCharSequence.toString());
          paramAnonymousNoMeasuredTextView.getPaint().setTextSize(paramAnonymousInt2);
          paramAnonymousString = TextUtils.ellipsize(paramAnonymousString, paramAnonymousNoMeasuredTextView.getPaint(), i - f2 - 20.0F, TextUtils.TruncateAt.END);
          paramAnonymousNoMeasuredTextView.getPaint().setTextSize(f1);
        }
        for (paramAnonymousNoMeasuredTextView = paramAnonymousCharSequence;; paramAnonymousNoMeasuredTextView = TextUtils.ellipsize(paramAnonymousCharSequence, paramAnonymousNoMeasuredTextView.getPaint(), i - f2, TextUtils.TruncateAt.END))
        {
          paramAnonymousCharSequence = com.tencent.mm.pluginsdk.ui.span.l.c(a.b(a.this), paramAnonymousNoMeasuredTextView + " " + paramAnonymousString);
          ColorStateList localColorStateList = com.tencent.mm.cb.a.m(a.c(a.this), paramAnonymousInt1);
          paramAnonymousCharSequence.setSpan(new TextAppearanceSpan(null, 0, paramAnonymousInt2, localColorStateList, localColorStateList), paramAnonymousNoMeasuredTextView.length() + 1, paramAnonymousNoMeasuredTextView.length() + 1 + paramAnonymousString.length(), 33);
          AppMethodBeat.o(233972);
          return paramAnonymousCharSequence;
        }
      }
    };
    this.dec = new a.3(this);
    this.sb = new StringBuilder(32);
    this.PSy = new SparseArray();
    this.PSz = new SparseArray();
    this.PSA = new HashSet();
    this.PSe = new HashMap();
    this.kRw = new WeakReference(paramContext);
    this.context = MMApplicationContext.getContext();
    this.PSf = paramString1;
    this.PSg = paramString2;
    this.type = paramInt;
    this.PSr = true;
    this.PSh = new LinkedList();
    this.PSi = new LinkedList();
    this.PSt = z.aTY();
    this.TAG = "MiscroMsg.AddressDrawWithCacheAdapter";
    AppMethodBeat.o(37572);
  }
  
  private boolean gUl()
  {
    AppMethodBeat.i(37575);
    if ((this.PSf.equals("@micromsg.qq.com")) || (this.PSf.equals("@all.contact.without.chatroom")) || (this.PSf.equals("@all.contact.without.chatroom.without.openim")))
    {
      AppMethodBeat.o(37575);
      return true;
    }
    AppMethodBeat.o(37575);
    return false;
  }
  
  public static String getDisplayName(String paramString1, String paramString2)
  {
    AppMethodBeat.i(37582);
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      AppMethodBeat.o(37582);
      return paramString1;
    }
    AppMethodBeat.o(37582);
    return paramString2;
  }
  
  private String getString(int paramInt)
  {
    AppMethodBeat.i(37587);
    String str2 = (String)this.PSy.get(paramInt);
    String str1 = str2;
    if (str2 == null)
    {
      str1 = this.context.getString(paramInt);
      this.PSy.put(paramInt, str1);
    }
    AppMethodBeat.o(37587);
    return str1;
  }
  
  protected int a(com.tencent.mm.storage.f paramf, int paramInt)
  {
    AppMethodBeat.i(37584);
    if (paramInt < this.PSo)
    {
      AppMethodBeat.o(37584);
      return 32;
    }
    if (paramf == null)
    {
      Log.e("MicroMsg.AddressAdapter", "contact is null, position:%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(37584);
      return -1;
    }
    paramInt = paramf.field_showHead;
    AppMethodBeat.o(37584);
    return paramInt;
  }
  
  protected void a(com.tencent.mm.storage.f paramf, b paramb)
  {
    AppMethodBeat.i(37580);
    try
    {
      paramb.jVP.setText(null);
      paramb.jVP.setVisibility(8);
      AppMethodBeat.o(37580);
      return;
    }
    catch (Throwable paramf)
    {
      AppMethodBeat.o(37580);
    }
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.AAA = paramf;
  }
  
  public final SparseArray<String>[] a(HashSet<f.b<String, com.tencent.mm.storage.f>> paramHashSet, SparseArray<String>[] paramArrayOfSparseArray)
  {
    AppMethodBeat.i(37590);
    paramHashSet = new SparseArray[paramArrayOfSparseArray.length];
    paramArrayOfSparseArray = new LinkedList();
    paramArrayOfSparseArray.add("weixin");
    long l = System.currentTimeMillis();
    bg.aVF();
    paramArrayOfSparseArray = com.tencent.mm.model.c.aSN().b(this.PSf, this.PSg, this.gzY, paramArrayOfSparseArray, gUl(), this.PSr);
    int i;
    if ((paramArrayOfSparseArray instanceof com.tencent.mm.storagebase.a.e))
    {
      d[] arrayOfd = ((com.tencent.mm.storagebase.a.e)paramArrayOfSparseArray).OtV;
      int k = arrayOfd.length;
      i = 0;
      while (i < k)
      {
        arrayOfd[i].akA(5000);
        paramHashSet[i] = new SparseArray();
        int j = 0;
        while (arrayOfd[i].moveToNext())
        {
          paramHashSet[i].put(j, arrayOfd[i].getString(0));
          j += 1;
        }
        i += 1;
      }
      this.PSo = arrayOfd[0].getCount();
    }
    for (;;)
    {
      paramArrayOfSparseArray.close();
      Log.d("MicroMsg.AddressAdapter", "refreshPosistion last :" + (System.currentTimeMillis() - l));
      AppMethodBeat.o(37590);
      return paramHashSet;
      paramHashSet[0] = new SparseArray();
      i = 0;
      while (paramArrayOfSparseArray.moveToNext())
      {
        paramHashSet[0].put(i, paramArrayOfSparseArray.getString(0));
        i += 1;
      }
    }
  }
  
  public final com.tencent.mm.ui.f<String, com.tencent.mm.storage.f>.c b(d<String> paramd)
  {
    AppMethodBeat.i(233974);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      paramd = new f.c(this, paramd, (byte)0);
      AppMethodBeat.o(233974);
      return paramd;
    }
    paramd = new f.c(this, paramd);
    AppMethodBeat.o(233974);
    return paramd;
  }
  
  protected String b(com.tencent.mm.storage.f paramf, int paramInt)
  {
    AppMethodBeat.i(37585);
    if (paramInt < this.PSo)
    {
      paramf = getString(2131755230);
      AppMethodBeat.o(37585);
      return paramf;
    }
    if (paramf.field_showHead == 31)
    {
      AppMethodBeat.o(37585);
      return "";
    }
    if (paramf.field_showHead == 123)
    {
      AppMethodBeat.o(37585);
      return "#";
    }
    if (paramf.field_showHead == 33)
    {
      paramf = getString(2131755192);
      AppMethodBeat.o(37585);
      return paramf;
    }
    if (paramf.field_showHead == 43)
    {
      paramf = getString(2131764705);
      AppMethodBeat.o(37585);
      return paramf;
    }
    if (paramf.field_showHead == 32)
    {
      paramf = getString(2131755230);
      AppMethodBeat.o(37585);
      return paramf;
    }
    String str = (String)this.PSy.get(paramf.field_showHead);
    if (str != null)
    {
      AppMethodBeat.o(37585);
      return str;
    }
    str = String.valueOf((char)paramf.field_showHead);
    this.PSy.put(paramf.field_showHead, str);
    AppMethodBeat.o(37585);
    return str;
  }
  
  protected void b(com.tencent.mm.storage.f paramf, b paramb)
  {
    AppMethodBeat.i(37581);
    Object localObject2;
    Object localObject1;
    if (as.bjp(paramf.field_username))
    {
      localObject2 = ((com.tencent.mm.openim.a.a)g.af(com.tencent.mm.openim.a.a.class)).bN(paramf.field_openImAppid, paramf.field_descWordingId);
      if (!Util.isNullOrNil((String)localObject2))
      {
        localObject1 = localObject2;
        if ("3552365301".equals(paramf.field_openImAppid)) {
          localObject1 = "@".concat(String.valueOf(localObject2));
        }
        paramb.PSD.aR((String)localObject1, 2131100666, 14);
        if ((!ab.Iy(paramf.field_username)) && (!ab.IB(paramf.field_username))) {
          break label247;
        }
        paramb.PSD.setCompoundRightDrawablesWithIntrinsicBounds(2131691298);
        paramb.PSD.setDrawRightDrawable(true);
        label127:
        localObject1 = paramf.NON;
        if (localObject1 != null) {
          break label274;
        }
      }
    }
    for (;;)
    {
      label247:
      CharSequence localCharSequence;
      try
      {
        localObject1 = com.tencent.mm.pluginsdk.ui.span.l.e(this.context, bnp(getDisplayName(paramf.arJ(), paramf.field_username)), com.tencent.mm.cb.a.aG(this.context, 2131165535));
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        paramb.PSD.setText((CharSequence)localObject2);
        ((com.tencent.mm.plugin.textstatus.a.c)g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).setTextWithStatus(paramb.PSD, paramf.field_username, com.tencent.mm.plugin.textstatus.a.a.b.FXh);
        AppMethodBeat.o(37581);
        return;
        paramb.PSD.aR(null, 0, 0);
        break;
        paramb.PSD.aR(null, 0, 0);
        break;
        if (!paramb.PSD.OVM) {
          break label127;
        }
        paramb.PSD.setDrawRightDrawable(false);
      }
      catch (Exception localException)
      {
        localCharSequence = null;
        continue;
      }
      label274:
      paramb.PSD.setText(localCharSequence);
    }
  }
  
  protected final String bnp(String paramString)
  {
    AppMethodBeat.i(37583);
    if (("".length() > 0) && (!"".equals(paramString)))
    {
      this.sb.append(paramString);
      this.sb.append("(");
      this.sb.append("");
      this.sb.append(")");
      paramString = this.sb.toString();
      this.sb.delete(0, this.sb.length());
      AppMethodBeat.o(37583);
      return paramString;
    }
    AppMethodBeat.o(37583);
    return paramString;
  }
  
  public final ArrayList<com.tencent.mm.storage.f> bo(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(37589);
    long l = System.currentTimeMillis();
    Object localObject = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      ((List)localObject).add((String)paramArrayList.get(i));
      i += 1;
    }
    paramArrayList = new ArrayList(((List)localObject).size());
    bg.aVF();
    localObject = com.tencent.mm.model.c.aSN().iK((List)localObject);
    while (((Cursor)localObject).moveToNext())
    {
      com.tencent.mm.storage.f localf = new com.tencent.mm.storage.f();
      localf.convertFrom((Cursor)localObject);
      paramArrayList.add(localf);
    }
    ((Cursor)localObject).close();
    Log.d("MicroMsg.AddressAdapter", "rebulidAllChangeData :" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(37589);
    return paramArrayList;
  }
  
  public final void detach()
  {
    AppMethodBeat.i(37573);
    if (this.kex != null)
    {
      this.kex.detach();
      this.kex = null;
    }
    AppMethodBeat.o(37573);
  }
  
  public final d<String> gGY()
  {
    AppMethodBeat.i(37588);
    d locald = (d)gUm();
    AppMethodBeat.o(37588);
    return locald;
  }
  
  protected Cursor gUm()
  {
    AppMethodBeat.i(37576);
    long l = System.currentTimeMillis();
    final LinkedList localLinkedList = new LinkedList();
    localLinkedList.add("weixin");
    bg.aVF();
    Cursor localCursor = com.tencent.mm.model.c.aSN().a(this.PSf, this.PSg, this.gzY, localLinkedList, gUl(), this.PSr);
    h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(233973);
        bg.aVF();
        Cursor localCursor = com.tencent.mm.model.c.aSN().a(a.this.PSf, a.this.PSg, a.this.gzY, localLinkedList, a.e(a.this), a.f(a.this));
        if (localCursor != null)
        {
          try
          {
            if (!(localCursor instanceof com.tencent.mm.storagebase.a.e)) {
              break label214;
            }
            ArrayList localArrayList = new ArrayList();
            d locald = ((com.tencent.mm.storagebase.a.e)localCursor).OtV[0];
            int i = locald.getPosition();
            if (locald != null)
            {
              while (locald.moveToNext())
              {
                com.tencent.mm.storage.f localf = new com.tencent.mm.storage.f();
                localf.convertFrom(locald);
                localArrayList.add(localf.field_username);
                Log.d("MicroMsg.AddressAdapter", "mStarUserList add %s %s", new Object[] { localf.field_username, localf.field_conRemark });
              }
              locald.moveToPosition(i);
            }
          }
          finally
          {
            if (localCursor != null) {
              localCursor.close();
            }
            AppMethodBeat.o(233973);
          }
          ((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).getFavourUserChecker().hp(localList);
        }
        label214:
        if (localCursor != null)
        {
          localCursor.close();
          AppMethodBeat.o(233973);
          return;
        }
        AppMethodBeat.o(233973);
      }
    });
    Log.d("MicroMsg.AddressAdapter", "kevin setCursor : " + (System.currentTimeMillis() - l));
    AppMethodBeat.o(37576);
    return localCursor;
  }
  
  protected final void gUn()
  {
    AppMethodBeat.i(37577);
    int k = getCount();
    if (k == 0)
    {
      AppMethodBeat.o(37577);
      return;
    }
    this.PSo = gGX();
    if (this.Paj != null)
    {
      this.PSk = ab.a(this.PSf, this.PSg, this.gzY, this.Paj);
      this.PSl = ab.a(this.PSf, this.PSg, this.Paj, this.gzY);
    }
    for (;;)
    {
      this.PSn.clear();
      if (this.PSk == null) {
        break;
      }
      Object localObject1 = this.PSk;
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        k = localObject1[i];
        this.PSn.add(Integer.valueOf(k - 1));
        i += 1;
      }
      long l;
      if (gFx())
      {
        l = System.currentTimeMillis();
        localObject1 = new HashSet();
        this.PSk = new int[30];
        this.PSl = new String[30];
        j = this.PSo;
        i = 0;
        if (j < k)
        {
          Object localObject2 = (com.tencent.mm.storage.f)akz(j);
          if (localObject2 != null)
          {
            localObject2 = b((com.tencent.mm.storage.f)localObject2, j);
            if (!((HashSet)localObject1).add(localObject2)) {
              break label268;
            }
            this.PSk[i] = (j - this.PSo);
            this.PSl[i] = localObject2;
            i += 1;
          }
          label268:
          for (;;)
          {
            j += 1;
            break;
            Log.d("MicroMsg.AddressAdapter", "newCursor getItem is null");
          }
        }
        Log.d("MicroMsg.AddressAdapter", "newCursor resetShowHead by Memory : " + (System.currentTimeMillis() - l) + "favourCount : " + this.PSo);
      }
      else
      {
        l = System.currentTimeMillis();
        this.PSk = ab.a(null, this.PSf, this.PSg, this.gzY, this.kdi);
        this.PSl = ab.a(null, this.PSf, this.PSg, this.kdi, this.gzY);
        Log.d("MicroMsg.AddressAdapter", "kevin resetShowHead part1 : " + (System.currentTimeMillis() - l));
      }
    }
    AppMethodBeat.o(37577);
  }
  
  public final void gUo()
  {
    AppMethodBeat.i(37578);
    this.plb.ebp();
    AppMethodBeat.o(37578);
  }
  
  public final void gUp()
  {
    AppMethodBeat.i(37591);
    super.o(null, 1);
    AppMethodBeat.o(37591);
  }
  
  public int getCount()
  {
    AppMethodBeat.i(37586);
    int i = super.getCount();
    AppMethodBeat.o(37586);
    return i;
  }
  
  public final int getPositionForSection(int paramInt)
  {
    int i = paramInt;
    if (this.PSk != null)
    {
      i = paramInt;
      if (paramInt >= 0)
      {
        i = paramInt;
        if (paramInt < this.PSk.length) {
          i = this.PSk[paramInt];
        }
      }
    }
    return this.PSo + i;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(37579);
    paramViewGroup = (Context)this.kRw.get();
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(37579);
      return paramView;
    }
    int i;
    if (!this.PSv)
    {
      i = 0;
      while (i < 8)
      {
        this.PSu.add(aa.jQ(paramViewGroup).inflate(2131492984, null));
        i += 1;
      }
      this.PSv = true;
    }
    com.tencent.mm.storage.f localf = (com.tencent.mm.storage.f)akz(paramInt);
    Object localObject1;
    label388:
    Object localObject2;
    label425:
    label564:
    Activity localActivity;
    if (paramView == null) {
      if (this.PSu.size() > 0)
      {
        paramView = (View)this.PSu.getFirst();
        this.PSu.removeFirst();
        paramViewGroup = new b();
        paramViewGroup.yuS = ((TextView)paramView.findViewById(2131299162));
        paramViewGroup.yuT = ((TextView)paramView.findViewById(2131299172));
        paramViewGroup.PSD = ((NoMeasuredTextView)paramView.findViewById(2131305207));
        paramViewGroup.PSD.setLayoutCallback(this.PSx);
        paramViewGroup.PSD.setTextSize(0, com.tencent.mm.cb.a.aG(this.context, 2131165535));
        paramViewGroup.PSD.setShouldEllipsize(true);
        if (paramViewGroup.PSD.getPaint() != null) {
          ao.a(paramViewGroup.PSD.getPaint(), 0.1F);
        }
        paramViewGroup.PSD.setTextColor(com.tencent.mm.cb.a.m(this.context, 2131100904));
        paramViewGroup.PSD.setGravity(16);
        paramViewGroup.gyr = ((ImageView)paramView.findViewById(2131296558));
        paramViewGroup.PSE = ((TextView)paramView.findViewById(2131299158));
        paramViewGroup.PSF = paramView.findViewById(2131299171);
        paramViewGroup.jVP = ((TextView)paramView.findViewById(2131305635));
        paramViewGroup.PSG = ((CategoryTipView)paramView.findViewById(2131299164));
        paramViewGroup.PSH = ((ViewGroup)paramView.findViewById(2131299161));
        localObject1 = paramViewGroup.PSF.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = ((int)(com.tencent.mm.cb.a.aH(this.context, 2131165246) * com.tencent.mm.cb.a.jj(this.context)));
        paramViewGroup.PSF.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramView.setTag(paramViewGroup);
        if (localf != null)
        {
          localObject2 = (com.tencent.mm.storage.f)akz(paramInt - 1);
          localObject1 = (com.tencent.mm.storage.f)akz(paramInt + 1);
          if (localObject2 != null) {
            break label791;
          }
          i = -1;
          int j = a(localf, paramInt);
          if (localObject1 != null) {
            a((com.tencent.mm.storage.f)localObject1, paramInt + 1);
          }
          paramViewGroup.PSG.setTag(Integer.valueOf(j));
          if ((!this.PSp) || (paramInt < 0) || (j == i)) {
            break label805;
          }
          localObject2 = b(localf, paramInt);
          if (Util.isNullOrNil((String)localObject2)) {
            break label805;
          }
          paramViewGroup.PSH.setVisibility(0);
          paramViewGroup.yuS.setVisibility(0);
          paramViewGroup.yuS.setText((CharSequence)localObject2);
          paramViewGroup.PSG.anG(((com.tencent.mm.plugin.story.api.e)g.ah(com.tencent.mm.plugin.story.api.e.class)).getFavourUserChecker().fna());
          label547:
          localObject2 = b(localf, paramInt);
          if (localObject1 != null) {
            break label835;
          }
          localObject1 = null;
          paramInt = paramViewGroup.PSF.getPaddingLeft();
          localActivity = (Activity)this.kRw.get();
          if ((localObject2 == null) || (((String)localObject2).equals(localObject1))) {
            break label849;
          }
          paramViewGroup.PSD.setBackground(null);
          paramViewGroup.PSF.setBackground(at.aN(localActivity, 2130969285));
        }
      }
    }
    for (;;)
    {
      paramViewGroup.PSF.setPadding(paramInt, 0, 0, 0);
      com.tencent.mm.pluginsdk.ui.a.b.c(paramViewGroup.gyr, localf.field_username);
      b(localf, paramViewGroup);
      a(localf, paramViewGroup);
      com.tencent.mm.plugin.sns.ui.e.a.b(0, (String)paramViewGroup.gyr.getTag(), (AvatarImageView)paramViewGroup.gyr);
      ((AvatarImageView)paramViewGroup.gyr).fL(localf.field_username, 0);
      ((AvatarImageView)paramViewGroup.gyr).setTag(localf.field_username);
      com.tencent.mm.plugin.sns.ui.e.a.a(0, localf.field_username, (AvatarImageView)paramViewGroup.gyr);
      ((AvatarImageView)paramViewGroup.gyr).setShowStoryHint(com.tencent.mm.plugin.sns.f.a.aOD(localf.field_username));
      paramViewGroup.gyr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37566);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/AddressDrawWithCacheAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.d("MicroMsg.AddressAdapter", "click avatarIv");
          if (paramAnonymousView == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressDrawWithCacheAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37566);
            return;
          }
          a.this.pkY.r(paramAnonymousView, a.this.pkZ.dr(paramAnonymousView), 2131296558);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressDrawWithCacheAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37566);
        }
      });
      AppMethodBeat.o(37579);
      return paramView;
      paramView = View.inflate(paramViewGroup, 2131492984, null);
      break;
      paramViewGroup = (b)paramView.getTag();
      break label388;
      label791:
      i = a((com.tencent.mm.storage.f)localObject2, paramInt - 1);
      break label425;
      label805:
      paramViewGroup.PSH.setVisibility(8);
      paramViewGroup.yuS.setVisibility(8);
      paramViewGroup.PSG.setVisibility(8);
      break label547;
      label835:
      localObject1 = b((com.tencent.mm.storage.f)localObject1, paramInt + 1);
      break label564;
      label849:
      paramViewGroup.PSD.setBackground(at.aN(localActivity, 2130969285));
      paramViewGroup.PSF.setBackground(null);
    }
  }
  
  public final void hi(String paramString, int paramInt)
  {
    AppMethodBeat.i(37569);
    if (paramInt == 5) {
      this.PSA.add(paramString);
    }
    super.o(paramString, paramInt);
    AppMethodBeat.o(37569);
  }
  
  public final void jB(List<String> paramList)
  {
    AppMethodBeat.i(37574);
    if (this.type != 2) {
      paramList.add(z.aTY());
    }
    bg.aVF();
    Object localObject = com.tencent.mm.model.c.aSW().aEY("@t.qq.com");
    if (localObject != null) {
      paramList.add(((ci)localObject).name);
    }
    if ((this.type == 3) || (this.type == 5) || (this.type == 4) || (this.type == 1) || (this.type == 0))
    {
      localObject = ab.aUU().iterator();
      while (((Iterator)localObject).hasNext()) {
        paramList.add((String)((Iterator)localObject).next());
      }
    }
    paramList.add("blogapp");
    this.gzY = paramList;
    AppMethodBeat.o(37574);
  }
  
  public void notifyDataSetChanged()
  {
    AppMethodBeat.i(37571);
    this.PSt = z.aTY();
    if (this.PSk == null) {
      gUn();
    }
    if (getCount() == 0)
    {
      super.notifyDataSetChanged();
      AppMethodBeat.o(37571);
      return;
    }
    this.PSo = gGX();
    Log.i("MicroMsg.AddressAdapter", "newcursor favourCount %d", new Object[] { Integer.valueOf(this.PSo) });
    super.notifyDataSetChanged();
    AppMethodBeat.o(37571);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(37592);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      Log.d("MicroMsg.AddressAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      AppMethodBeat.o(37592);
      return;
    }
    bg.aVF();
    if (paramMStorageEx == com.tencent.mm.model.c.aSN()) {
      if ((!ab.IR((String)paramObject)) && (!this.PSA.contains((String)paramObject)))
      {
        super.o((String)paramObject, 2);
        if ((this.PSs) && (this.PSm != null))
        {
          this.PSm.PTd = true;
          Log.d("MicroMsg.AddressAdapter", "ADDRESS onNotifyChange");
          AppMethodBeat.o(37592);
        }
      }
      else
      {
        Log.d("MicroMsg.AddressAdapter", "newcursor is stranger ，return");
      }
    }
    AppMethodBeat.o(37592);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(37570);
    this.PSA.clear();
    super.pause();
    AppMethodBeat.o(37570);
  }
  
  public final void setFragment(Fragment paramFragment)
  {
    this.PSm = ((AddressUI.AddressUIFragment)paramFragment);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.pkZ = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.pkY = paramg;
  }
  
  public static abstract interface a {}
  
  protected static final class b
  {
    public NoMeasuredTextView PSD;
    public TextView PSE;
    public View PSF;
    public CategoryTipView PSG;
    public ViewGroup PSH;
    public ImageView gyr;
    public TextView jVP;
    public TextView yuS;
    public TextView yuT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a
 * JD-Core Version:    0.7.0.1
 */