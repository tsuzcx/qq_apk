package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.k.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.ffb;
import com.tencent.mm.protocal.protobuf.gom;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.tools.g;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/widget/Tiger2022Helper;", "", "()V", "MAX_COUNT", "", "MIN_COUNT", "TAG", "", "linkStatus", "Lcom/tencent/mm/plugin/sns/ui/widget/Tiger2022Helper$LinkStatus;", "postStatus", "Lcom/tencent/mm/plugin/sns/ui/widget/Tiger2022Helper$PostStatus;", "count", "text", "", "countRaw", "", "getSharedFinderLive", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "highlight", "Landroid/text/Spannable;", "content", "isCommentHighlightEnabled", "", "isEntryOptionVisible", "isLinkEnabled", "isTiger2022", "timeline", "Lcom/tencent/mm/protocal/protobuf/TimeLineObject;", "redirectToFinderLive", "context", "Landroid/content/Context;", "removeHighlightSpan", "", "editable", "Landroid/text/Editable;", "shouldHighlightComment", "comment", "shouldShowLink", "updateServerConfig", "config", "Lcom/tencent/mm/protocal/protobuf/SnsServerConfig;", "InputFilter", "LinkStatus", "PostStatus", "Tiger22CommentSpan", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class Tiger2022Helper
{
  public static final Tiger2022Helper akja;
  private static c akjb;
  private static b akjc;
  
  static
  {
    AppMethodBeat.i(369986);
    akja = new Tiger2022Helper();
    akjb = c.akjg;
    akjc = b.akjd;
    Object localObject = MultiProcessMMKV.getMMKV("SnsMMKV");
    c localc = (c)kotlin.a.k.m(c.values(), ((MultiProcessMMKV)localObject).getInt("SnsTiger2022PostStatus", c.akjg.ordinal()));
    if (localc != null) {
      akjb = localc;
    }
    localObject = (b)kotlin.a.k.m(b.values(), ((MultiProcessMMKV)localObject).getInt("SnsTiger2022LINKStatus", b.akjd.ordinal()));
    if (localObject != null) {
      akjc = (b)localObject;
    }
    AppMethodBeat.o(369986);
  }
  
  public static final void a(ffb paramffb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(369971);
    if (paramffb != null)
    {
      localObject1 = (c)kotlin.a.k.m(c.values(), paramffb.akln);
      if (localObject1 != null) {
        akjb = (c)localObject1;
      }
      localObject1 = (b)kotlin.a.k.m(b.values(), paramffb.aklo);
      if (localObject1 != null) {
        akjc = (b)localObject1;
      }
    }
    Object localObject1 = com.tencent.d.a.a.a.a.a.ahiX;
    int i = ((Number)com.tencent.d.a.a.a.a.a.kMC().bmg()).intValue();
    if (i != -1)
    {
      localObject1 = (c)kotlin.a.k.m(c.values(), i);
      if (localObject1 != null) {
        akjb = (c)localObject1;
      }
    }
    localObject1 = com.tencent.d.a.a.a.a.a.ahiX;
    int j = ((Number)com.tencent.d.a.a.a.a.a.kMD().bmg()).intValue();
    if (j != -1)
    {
      localObject1 = (b)kotlin.a.k.m(b.values(), j);
      if (localObject1 != null) {
        akjc = (b)localObject1;
      }
    }
    localObject1 = MultiProcessMMKV.getMMKV("SnsMMKV");
    ((MultiProcessMMKV)localObject1).putInt("SnsTiger2022PostStatus", akjb.ordinal());
    ((MultiProcessMMKV)localObject1).putInt("SnsTiger2022LINKStatus", akjc.ordinal());
    StringBuilder localStringBuilder = new StringBuilder("updatePostStatus: server(");
    if (paramffb == null)
    {
      localObject1 = null;
      localObject1 = localStringBuilder.append(localObject1).append(", ");
      if (paramffb != null) {
        break label281;
      }
    }
    label281:
    for (paramffb = localObject2;; paramffb = Integer.valueOf(paramffb.aklo))
    {
      Log.i("MicroMsg.Tiger2022Helper", paramffb + "), result(" + akjb + ", " + akjc + "), debug(" + i + ", " + j + ')');
      AppMethodBeat.o(369971);
      return;
      localObject1 = Integer.valueOf(paramffb.akln);
      break;
    }
  }
  
  public static final boolean a(Context paramContext, TimeLineObject paramTimeLineObject)
  {
    gom localgom = null;
    AppMethodBeat.i(369984);
    s.u(paramContext, "context");
    Object localObject1;
    if (h(paramTimeLineObject))
    {
      if (paramTimeLineObject != null) {
        break label41;
      }
      localObject1 = localgom;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(369984);
      return false;
      label41:
      localObject2 = paramTimeLineObject.ContentObj;
      localObject1 = localgom;
      if (localObject2 != null)
      {
        localObject2 = ((agh)localObject2).akiL;
        localObject1 = localgom;
        if (localObject2 != null) {
          localObject1 = ((gom)localObject2).aklq;
        }
      }
    }
    Log.i("MicroMsg.Tiger2022Helper", "redirect to finder live");
    localgom = paramTimeLineObject.ContentObj.akiL;
    Object localObject2 = paramTimeLineObject.ContentObj.akiL.aklq;
    s.s(localObject2, "timeline.ContentObj.tiger2022.finderLive");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_from_profile_share_scene", 3);
    localIntent.putExtra("key_enter_profile_type", 8);
    if (Util.isNullOrNil(((bmr)localObject2).username))
    {
      localIntent.putExtra("finder_username", "");
      localIntent.putExtra("key_finder_object_Id", ((bmr)localObject2).feedId);
      localIntent.putExtra("key_finder_object_nonce_id_key", ((bmr)localObject2).objectNonceId);
    }
    for (;;)
    {
      if (!Util.isNullOrNil(((bmr)localObject2).nickName)) {
        localIntent.putExtra("key_finder_teen_mode_user_name", ((bmr)localObject2).nickName);
      }
      localIntent.putExtra("key_finder_teen_mode_check", ((cn)h.az(cn.class)).getFinderUtilApi().fgH());
      localIntent.putExtra("key_finder_teen_mode_scene", 3);
      localObject1 = new i();
      ((i)localObject1).n("is_temporary", Integer.valueOf(1));
      localIntent.putExtra("key_chnl_extra", ((i)localObject1).toString());
      localObject1 = Util.nullAsNil(((com.tencent.mm.plugin.expt.b.d)h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN());
      Object localObject3 = Util.nullAsNil(paramTimeLineObject.UserName);
      s.s(localObject3, "nullAsNil(timeline.UserName)");
      String str = ((bmr)localObject2).feedId;
      paramTimeLineObject = paramTimeLineObject.Id;
      s.s(paramTimeLineObject, "timeline.Id");
      Log.i("MicroMsg.TimeLineClickEvent", s.X("report20587, ", localObject1 + ',' + (String)localObject3 + ',' + str + ',' + paramTimeLineObject));
      localIntent.putExtra("key_enter_live_param_visitor_enter_scene", 6);
      localObject3 = (com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class);
      long l = com.tencent.mm.ae.d.FK(((bmr)localObject2).liveId);
      localObject1 = ((bmr)localObject2).username;
      paramTimeLineObject = (TimeLineObject)localObject1;
      if (localObject1 == null) {
        paramTimeLineObject = "";
      }
      localObject1 = ((cn)h.az(cn.class)).genContextId(4, 2, 65);
      s.s(localObject1, "plugin(IPluginFinder::cl…a).genContextId(4, 2, 65)");
      ((com.tencent.d.a.a.a.b)localObject3).enterFinderLiveTiger(localIntent, paramContext, Long.valueOf(l), paramTimeLineObject, (String)localObject1, false, localgom.aklr, Long.valueOf(com.tencent.mm.ae.d.FK(((bmr)localObject2).feedId)), ((bmr)localObject2).objectNonceId, ((bmr)localObject2).desc);
      AppMethodBeat.o(369984);
      return true;
      localIntent.putExtra("finder_username", ((bmr)localObject2).username);
      localIntent.putExtra("key_finder_teen_mode_user_id", ((bmr)localObject2).username);
    }
  }
  
  public static final boolean b(TimeLineObject paramTimeLineObject, String paramString)
  {
    AppMethodBeat.i(369977);
    if (!kLN())
    {
      AppMethodBeat.o(369977);
      return false;
    }
    if (!h(paramTimeLineObject))
    {
      AppMethodBeat.o(369977);
      return false;
    }
    if (paramTimeLineObject == null)
    {
      paramTimeLineObject = null;
      if (paramTimeLineObject != null) {
        if (((CharSequence)paramTimeLineObject).length() != 0) {
          break label79;
        }
      }
    }
    label79:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label84;
      }
      AppMethodBeat.o(369977);
      return false;
      paramTimeLineObject = paramTimeLineObject.ContentDesc;
      break;
    }
    label84:
    if (paramString != null) {
      if (((CharSequence)paramString).length() != 0) {
        break label114;
      }
    }
    label114:
    for (i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(369977);
      return false;
    }
    if (bD((CharSequence)paramTimeLineObject) == bD((CharSequence)paramString))
    {
      AppMethodBeat.o(369977);
      return true;
    }
    AppMethodBeat.o(369977);
    return false;
  }
  
  public static final int bC(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(369974);
    int i = (int)Math.ceil(bD(paramCharSequence));
    AppMethodBeat.o(369974);
    return i;
  }
  
  private static double bD(CharSequence paramCharSequence)
  {
    double d = 0.0D;
    AppMethodBeat.i(369975);
    if (paramCharSequence == null)
    {
      AppMethodBeat.o(369975);
      return 0.0D;
    }
    if (s.p(paramCharSequence.toString(), " "))
    {
      AppMethodBeat.o(369975);
      return 0.5D;
    }
    Object localObject = MMApplicationContext.getContext();
    paramCharSequence = paramCharSequence.toString();
    if (paramCharSequence == null)
    {
      paramCharSequence = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(369975);
      throw paramCharSequence;
    }
    paramCharSequence = com.tencent.mm.ui.i.c.b.a((Context)localObject, (CharSequence)n.bq((CharSequence)paramCharSequence).toString(), 0);
    if (paramCharSequence == null)
    {
      paramCharSequence = new NullPointerException("null cannot be cast to non-null type android.text.Spannable");
      AppMethodBeat.o(369975);
      throw paramCharSequence;
    }
    localObject = (Spannable)paramCharSequence;
    int i = 0;
    if (i < ((Spannable)localObject).length())
    {
      com.tencent.mm.smiley.k[] arrayOfk = (com.tencent.mm.smiley.k[])((Spannable)localObject).getSpans(i, i, com.tencent.mm.smiley.k.class);
      int j;
      if (arrayOfk != null)
      {
        if (arrayOfk.length != 0) {
          break label202;
        }
        j = 1;
        label169:
        if (j == 0) {
          break label208;
        }
      }
      label271:
      label285:
      for (d += g.bCx(String.valueOf(((Spannable)localObject).charAt(i))) / 2.0F;; d += g.bCx(String.valueOf(((Spannable)localObject).charAt(i))) / 2.0F)
      {
        i += 1;
        break;
        label202:
        j = 0;
        break label169;
        label208:
        int m = arrayOfk.length;
        j = 0;
        label216:
        int k;
        if (j < m)
        {
          paramCharSequence = arrayOfk[j];
          if (paramCharSequence.start == i)
          {
            k = 1;
            label240:
            if (k == 0) {
              break label271;
            }
          }
        }
        for (;;)
        {
          if (paramCharSequence == null) {
            break label285;
          }
          i = ((Spannable)localObject).getSpanEnd(paramCharSequence);
          d += 1.0D;
          break;
          k = 0;
          break label240;
          j += 1;
          break label216;
          paramCharSequence = null;
        }
      }
    }
    AppMethodBeat.o(369975);
    return d;
  }
  
  public static final Spannable bE(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(369978);
    s.u(paramCharSequence, "content");
    if ((paramCharSequence instanceof Spannable)) {}
    for (Spannable localSpannable1 = (Spannable)paramCharSequence;; localSpannable1 = null)
    {
      Spannable localSpannable2 = localSpannable1;
      if (localSpannable1 == null) {
        localSpannable2 = (Spannable)new SpannableString(paramCharSequence);
      }
      localSpannable2.setSpan(new Tiger22CommentSpan(), 0, paramCharSequence.length(), 33);
      AppMethodBeat.o(369978);
      return localSpannable2;
    }
  }
  
  public static final void g(Editable paramEditable)
  {
    int i = 0;
    AppMethodBeat.i(369979);
    s.u(paramEditable, "editable");
    Tiger22CommentSpan[] arrayOfTiger22CommentSpan = (Tiger22CommentSpan[])paramEditable.getSpans(0, paramEditable.length(), Tiger22CommentSpan.class);
    s.s(arrayOfTiger22CommentSpan, "spans");
    int j = arrayOfTiger22CommentSpan.length;
    while (i < j)
    {
      paramEditable.removeSpan(arrayOfTiger22CommentSpan[i]);
      i += 1;
    }
    AppMethodBeat.o(369979);
  }
  
  public static final boolean h(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(369980);
    if (((com.tencent.mm.plugin.zero.b.a)h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("SnsTiger2022Enabled", 1) == 0)
    {
      AppMethodBeat.o(369980);
      return false;
    }
    if (paramTimeLineObject == null) {
      paramTimeLineObject = null;
    }
    while (paramTimeLineObject != null)
    {
      AppMethodBeat.o(369980);
      return true;
      paramTimeLineObject = paramTimeLineObject.ContentObj;
      if (paramTimeLineObject == null) {
        paramTimeLineObject = null;
      } else {
        paramTimeLineObject = paramTimeLineObject.akiL;
      }
    }
    AppMethodBeat.o(369980);
    return false;
  }
  
  public static final boolean i(TimeLineObject paramTimeLineObject)
  {
    AppMethodBeat.i(369981);
    if (paramTimeLineObject == null)
    {
      AppMethodBeat.o(369981);
      return false;
    }
    if (!h(paramTimeLineObject))
    {
      AppMethodBeat.o(369981);
      return false;
    }
    paramTimeLineObject = paramTimeLineObject.ContentObj.akiL;
    if (!paramTimeLineObject.aklp)
    {
      AppMethodBeat.o(369981);
      return false;
    }
    if (akjc == b.akje)
    {
      AppMethodBeat.o(369981);
      return false;
    }
    if (paramTimeLineObject.aklq != null)
    {
      AppMethodBeat.o(369981);
      return true;
    }
    AppMethodBeat.o(369981);
    return false;
  }
  
  public static final bmr kLM()
  {
    AppMethodBeat.i(369973);
    localObject = MultiProcessMMKV.getMMKV("FINDER_LIVE_MMKV");
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((MultiProcessMMKV)localObject).decodeBytes("MMKV_KEY_FINDER_LIVE_TIGER"))
    {
      AppMethodBeat.o(369973);
      return null;
    }
    try
    {
      bmr localbmr = new bmr();
      localbmr.parseFrom((byte[])localObject);
      localObject = localbmr;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Tiger2022Helper", (Throwable)localException, "unable to parse saved finder live: " + localObject.length + " bytes", new Object[0]);
        localObject = null;
      }
    }
    AppMethodBeat.o(369973);
    return localObject;
  }
  
  public static final boolean kLN()
  {
    AppMethodBeat.i(369976);
    if (((com.tencent.mm.plugin.zero.b.a)h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("SnsTiger2022ReplySpecialEffectsEnabled", 1) == 1)
    {
      AppMethodBeat.o(369976);
      return true;
    }
    AppMethodBeat.o(369976);
    return false;
  }
  
  public static final boolean kLO()
  {
    AppMethodBeat.i(369982);
    if (akjb == c.akjj)
    {
      AppMethodBeat.o(369982);
      return false;
    }
    if (kLM() != null)
    {
      AppMethodBeat.o(369982);
      return true;
    }
    AppMethodBeat.o(369982);
    return false;
  }
  
  public static final boolean kLP()
  {
    AppMethodBeat.i(369983);
    c localc = akjb;
    switch (d.$EnumSwitchMapping$0[localc.ordinal()])
    {
    }
    do
    {
      AppMethodBeat.o(369983);
      return true;
      AppMethodBeat.o(369983);
      return false;
    } while (kLM() != null);
    AppMethodBeat.o(369983);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/widget/Tiger2022Helper$Tiger22CommentSpan;", "Landroid/text/style/ForegroundColorSpan;", "()V", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class Tiger22CommentSpan
    extends ForegroundColorSpan
  {
    public Tiger22CommentSpan()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/widget/Tiger2022Helper$InputFilter;", "Landroid/text/InputFilter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "onReachLimitation", "", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements InputFilter
  {
    private final Context context;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(369963);
      this.context = paramContext;
      AppMethodBeat.o(369963);
    }
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(369964);
      s.u(paramCharSequence, "source");
      s.u(paramSpanned, "dest");
      Tiger2022Helper localTiger2022Helper = Tiger2022Helper.akja;
      double d = Tiger2022Helper.bF((CharSequence)paramSpanned);
      paramSpanned = Tiger2022Helper.akja;
      if (d + Tiger2022Helper.bF(paramCharSequence) > 9.0D)
      {
        aa.makeText(this.context, (CharSequence)this.context.getString(b.j.sns_tiger2022_input_warning), 0).show();
        paramCharSequence = this.context.getSystemService("vibrator");
        if (paramCharSequence == null)
        {
          paramCharSequence = new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
          AppMethodBeat.o(369964);
          throw paramCharSequence;
        }
        ((Vibrator)paramCharSequence).vibrate(10L);
        paramCharSequence = (CharSequence)"";
        AppMethodBeat.o(369964);
        return paramCharSequence;
      }
      AppMethodBeat.o(369964);
      return paramCharSequence;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/widget/Tiger2022Helper$LinkStatus;", "", "(Ljava/lang/String;I)V", "Visible", "Invisible", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    static
    {
      AppMethodBeat.i(369968);
      akjd = new b("Visible", 0);
      akje = new b("Invisible", 1);
      akjf = new b[] { akjd, akje };
      AppMethodBeat.o(369968);
    }
    
    private b() {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/widget/Tiger2022Helper$PostStatus;", "", "(Ljava/lang/String;I)V", "PostDisabled", "LiveRoomWithLink", "PostOpenLiveWithLink", "PostOpenWithoutLink", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum c
  {
    static
    {
      AppMethodBeat.i(369972);
      akjg = new c("PostDisabled", 0);
      akjh = new c("LiveRoomWithLink", 1);
      akji = new c("PostOpenLiveWithLink", 2);
      akjj = new c("PostOpenWithoutLink", 3);
      akjk = new c[] { akjg, akjh, akji, akjj };
      AppMethodBeat.o(369972);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.Tiger2022Helper
 * JD-Core Version:    0.7.0.1
 */