package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import java.sql.Time;
import java.text.DateFormat;

public class HardCoderSettingUI
  extends MMActivity
{
  private CheckBox LbQ;
  private EditText LbR;
  private CheckBox LbS;
  private CheckBox LbT;
  private CheckBox LbU;
  private TextView LbV;
  private TextView LbW;
  private CheckBox LbX;
  private EditText LbY;
  private EditText LbZ;
  private EditText LcA;
  private EditText LcB;
  private EditText LcC;
  private Spinner LcD;
  private Spinner LcE;
  private CheckBox LcF;
  private CheckBox LcG;
  private EditText LcH;
  private EditText LcI;
  private EditText LcJ;
  private Spinner LcK;
  private Spinner LcL;
  private CheckBox LcM;
  private CheckBox LcN;
  private EditText LcO;
  private EditText LcP;
  private EditText LcQ;
  private Spinner LcR;
  private Spinner LcS;
  private CheckBox LcT;
  private EditText LcU;
  private CheckBox LcV;
  private EditText LcW;
  private EditText LcX;
  private EditText LcY;
  private EditText LcZ;
  private EditText Lca;
  private Spinner Lcb;
  private Spinner Lcc;
  private CheckBox Lcd;
  private CheckBox Lce;
  private EditText Lcf;
  private EditText Lcg;
  private EditText Lch;
  private Spinner Lci;
  private Spinner Lcj;
  private CheckBox Lck;
  private CheckBox Lcl;
  private EditText Lcm;
  private EditText Lcn;
  private EditText Lco;
  private Spinner Lcp;
  private Spinner Lcq;
  private CheckBox Lcr;
  private CheckBox Lcs;
  private EditText Lct;
  private EditText Lcu;
  private EditText Lcv;
  private Spinner Lcw;
  private Spinner Lcx;
  private CheckBox Lcy;
  private CheckBox Lcz;
  private CheckBox LdA;
  private EditText LdB;
  private EditText LdC;
  private EditText LdD;
  private Spinner LdE;
  private Spinner LdF;
  private CheckBox LdG;
  private CheckBox LdH;
  private EditText LdI;
  private EditText LdJ;
  private EditText LdK;
  private Spinner LdL;
  private Spinner LdM;
  private CheckBox LdN;
  private CheckBox LdO;
  private EditText LdP;
  private EditText LdQ;
  private EditText LdR;
  private Spinner LdS;
  private Spinner LdT;
  private CheckBox LdU;
  private CheckBox LdV;
  private EditText LdW;
  private EditText LdX;
  private EditText LdY;
  private Spinner LdZ;
  private EditText Lda;
  private EditText Ldb;
  private Spinner Ldc;
  private Spinner Ldd;
  private CheckBox Lde;
  private CheckBox Ldf;
  private EditText Ldg;
  private EditText Ldh;
  private EditText Ldi;
  private Spinner Ldj;
  private Spinner Ldk;
  private CheckBox Ldl;
  private CheckBox Ldm;
  private EditText Ldn;
  private EditText Ldo;
  private EditText Ldp;
  private Spinner Ldq;
  private Spinner Ldr;
  private CheckBox Lds;
  private CheckBox Ldt;
  private EditText Ldu;
  private EditText Ldv;
  private EditText Ldw;
  private Spinner Ldx;
  private Spinner Ldy;
  private CheckBox Ldz;
  private Spinner Lea;
  private CheckBox Leb;
  private CheckBox Lec;
  private EditText Led;
  private EditText Lee;
  private EditText Lef;
  private Spinner Leg;
  private Spinner Leh;
  private CheckBox Lei;
  private CheckBox Lej;
  private EditText Lek;
  private EditText Lel;
  private EditText Lem;
  private Spinner Len;
  private Spinner Leo;
  private CheckBox Lep;
  private CheckBox Leq;
  private EditText Ler;
  private EditText Les;
  private EditText Let;
  private Spinner Leu;
  private Spinner Lev;
  private CheckBox Lew;
  private boolean yWr;
  private final TimePickerDialog.OnTimeSetListener yWs;
  
  public HardCoderSettingUI()
  {
    AppMethodBeat.i(39064);
    this.yWr = false;
    this.yWs = new TimePickerDialog.OnTimeSetListener()
    {
      public final void onTimeSet(TimePicker paramAnonymousTimePicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(39063);
        if (HardCoderSettingUI.s(HardCoderSettingUI.this))
        {
          WXHardCoderJNI.hcBeginTimeHour = paramAnonymousInt1;
          WXHardCoderJNI.hcBeginTimeMin = paramAnonymousInt2;
          HardCoderSettingUI.t(HardCoderSettingUI.this).setText(HardCoderSettingUI.m(HardCoderSettingUI.this, WXHardCoderJNI.hcBeginTimeHour, WXHardCoderJNI.hcBeginTimeMin));
          AppMethodBeat.o(39063);
          return;
        }
        WXHardCoderJNI.hcEndTimeHour = paramAnonymousInt1;
        WXHardCoderJNI.hcEndTimeMin = paramAnonymousInt2;
        HardCoderSettingUI.u(HardCoderSettingUI.this).setText(HardCoderSettingUI.m(HardCoderSettingUI.this, WXHardCoderJNI.hcEndTimeHour, WXHardCoderJNI.hcEndTimeMin));
        AppMethodBeat.o(39063);
      }
    };
    AppMethodBeat.o(39064);
  }
  
  private static void b(SharedPreferences.Editor paramEditor)
  {
    AppMethodBeat.i(39068);
    paramEditor.putBoolean("KEY_HC_ENABLE", WXHardCoderJNI.getEnable());
    paramEditor.putBoolean("KEY_HC_DEBUG", WXHardCoderJNI.getDebug());
    paramEditor.putInt("KEY_HC_RETRY_INTERVAL", WXHardCoderJNI.hcRetryInterval);
    paramEditor.putBoolean("KEY_HC_TIME_LIMIT", WXHardCoderJNI.hcTimeLimit);
    paramEditor.putInt("KEY_HC_BEGIN_TIME_HOUR", WXHardCoderJNI.hcBeginTimeHour);
    paramEditor.putInt("KEY_HC_BEGIN_TIME_MIN", WXHardCoderJNI.hcBeginTimeMin);
    paramEditor.putInt("KEY_HC_END_TIME_HOUR", WXHardCoderJNI.hcEndTimeHour);
    paramEditor.putInt("KEY_HC_END_TIME_MIN", WXHardCoderJNI.hcEndTimeMin);
    paramEditor.putBoolean("KEY_HC_BOOT_ENABLE", WXHardCoderJNI.hcBootEnable);
    paramEditor.putInt("KEY_HC_BOOT_DELEY", WXHardCoderJNI.hcBootDelay);
    paramEditor.putInt("KEY_HC_BOOT_CPU", WXHardCoderJNI.hcBootCPU);
    paramEditor.putInt("KEY_HC_BOOT_IO", WXHardCoderJNI.hcBootIO);
    paramEditor.putBoolean("KEY_HC_BOOT_THR", WXHardCoderJNI.hcBootThr);
    paramEditor.putInt("KEY_HC_BOOT_TIMEOUT", WXHardCoderJNI.hcBootTimeout);
    paramEditor.putLong("KEY_HC_BOOT_ACTION", WXHardCoderJNI.hcBootAction);
    paramEditor.putBoolean("KEY_HC_ENTER_CHATTING_ENABLE", WXHardCoderJNI.hcEnterChattingEnable);
    paramEditor.putInt("KEY_HC_ENTER_CHATTING_DELEY", WXHardCoderJNI.hcEnterChattingDelay);
    paramEditor.putInt("KEY_HC_ENTER_CHATTING_CPU", WXHardCoderJNI.hcEnterChattingCPU);
    paramEditor.putInt("KEY_HC_ENTER_CHATTING_IO", WXHardCoderJNI.hcEnterChattingIO);
    paramEditor.putBoolean("KEY_HC_ENTER_CHATTING_THR", WXHardCoderJNI.hcEnterChattingThr);
    paramEditor.putInt("KEY_HC_ENTER_CHATTING_TIMEOUT", WXHardCoderJNI.hcEnterChattingTimeout);
    paramEditor.putLong("KEY_HC_ENTER_CHATTING_ACTION", WXHardCoderJNI.hcEnterChattingAction);
    paramEditor.putBoolean("KEY_HC_QUIT_CHATTING_ENABLE", WXHardCoderJNI.hcQuitChattingEnable);
    paramEditor.putInt("KEY_HC_QUIT_CHATTING_DELEY", WXHardCoderJNI.hcQuitChattingDelay);
    paramEditor.putInt("KEY_HC_QUIT_CHATTING_CPU", WXHardCoderJNI.hcQuitChattingCPU);
    paramEditor.putInt("KEY_HC_QUIT_CHATTING_IO", WXHardCoderJNI.hcQuitChattingIO);
    paramEditor.putBoolean("KEY_HC_QUIT_CHATTING_THR", WXHardCoderJNI.hcQuitChattingThr);
    paramEditor.putInt("KEY_HC_QUIT_CHATTING_TIMEOUT", WXHardCoderJNI.hcQuitChattingTimeout);
    paramEditor.putLong("KEY_HC_QUIT_CHATTING_ACTION", WXHardCoderJNI.hcQuitChattingAction);
    paramEditor.putBoolean("KEY_HC_SEND_MSG_ENABLE", WXHardCoderJNI.hcSendMsgEnable);
    paramEditor.putInt("KEY_HC_SEND_MSG_DELEY", WXHardCoderJNI.hcSendMsgDelay);
    paramEditor.putInt("KEY_HC_SEND_MSG_CPU", WXHardCoderJNI.hcSendMsgCPU);
    paramEditor.putInt("KEY_HC_SEND_MSG_IO", WXHardCoderJNI.hcSendMsgIO);
    paramEditor.putBoolean("KEY_HC_SEND_MSG_THR", WXHardCoderJNI.hcSendMsgThr);
    paramEditor.putInt("KEY_HC_SEND_MSG_TIMEOUT", WXHardCoderJNI.hcSendMsgTimeout);
    paramEditor.putLong("KEY_HC_SEND_MSG_ACTION", WXHardCoderJNI.hcSendMsgAction);
    paramEditor.putBoolean("KEY_HC_SEND_PIC_MSG_ENABLE", WXHardCoderJNI.hcSendPicMsgEnable);
    paramEditor.putInt("KEY_HC_SEND_PIC_MSG_DELEY", WXHardCoderJNI.hcSendPicMsgDelay);
    paramEditor.putInt("KEY_HC_SEND_PIC_MSG_CPU", WXHardCoderJNI.hcSendPicMsgCPU);
    paramEditor.putInt("KEY_HC_SEND_PIC_MSG_IO", WXHardCoderJNI.hcSendPicMsgIO);
    paramEditor.putBoolean("KEY_HC_SEND_PIC_MSG_THR", WXHardCoderJNI.hcSendPicMsgThr);
    paramEditor.putInt("KEY_HC_SEND_PIC_MSG_TIMEOUT", WXHardCoderJNI.hcSendPicMsgTimeout);
    paramEditor.putLong("KEY_HC_SEND_PIC_MSG_ACTION", WXHardCoderJNI.hcSendPicMsgAction);
    paramEditor.putBoolean("KEY_HC_RECEIVE_MSG_ENABLE", WXHardCoderJNI.hcReceiveMsgEnable);
    paramEditor.putInt("KEY_HC_RECEIVE_MSG_DELEY", WXHardCoderJNI.hcReceiveMsgDelay);
    paramEditor.putInt("KEY_HC_RECEIVE_MSG_CPU", WXHardCoderJNI.hcReceiveMsgCPU);
    paramEditor.putInt("KEY_HC_RECEIVE_MSG_IO", WXHardCoderJNI.hcReceiveMsgIO);
    paramEditor.putBoolean("KEY_HC_RECEIVE_MSG_THR", WXHardCoderJNI.hcReceiveMsgThr);
    paramEditor.putInt("KEY_HC_RECEIVE_MSG_TIMEOUT", WXHardCoderJNI.hcReceiveMsgTimeout);
    paramEditor.putLong("KEY_HC_RECEIVE_MSG_ACTION", WXHardCoderJNI.hcReceiveMsgAction);
    paramEditor.putBoolean("KEY_HC_UPDATE_CHATROOM_ENABLE", WXHardCoderJNI.hcUpdateChatroomEnable);
    paramEditor.putInt("KEY_HC_UPDATE_CHATROOM_DELEY", WXHardCoderJNI.hcUpdateChatroomDelay);
    paramEditor.putInt("KEY_HC_UPDATE_CHATROOM_CPU", WXHardCoderJNI.hcUpdateChatroomCPU);
    paramEditor.putInt("KEY_HC_UPDATE_CHATROOM_IO", WXHardCoderJNI.hcUpdateChatroomIO);
    paramEditor.putBoolean("KEY_HC_UPDATE_CHATROOM_THR", WXHardCoderJNI.hcUpdateChatroomThr);
    paramEditor.putInt("KEY_HC_UPDATE_CHATROOM_TIMEOUT", WXHardCoderJNI.hcUpdateChatroomTimeout);
    paramEditor.putLong("KEY_HC_UPDATE_CHATROOM_ACTION", WXHardCoderJNI.hcUpdateChatroomAction);
    paramEditor.putLong("KEY_HC_UPDATE_CHATROOM_MEMBER_COUNT", WXHardCoderJNI.hcUpdateChatroomMemberCount);
    paramEditor.putBoolean("KEY_HC_DB_ENABLE", WXHardCoderJNI.hcDBEnable);
    paramEditor.putInt("KEY_HC_DB_DELEY_QUERY", WXHardCoderJNI.hcDBDelayQuery);
    paramEditor.putInt("KEY_HC_DB_DELEY_WRITE", WXHardCoderJNI.hcDBDelayWrite);
    paramEditor.putInt("KEY_HC_DB_CPU", WXHardCoderJNI.hcDBCPU);
    paramEditor.putInt("KEY_HC_DB_IO", WXHardCoderJNI.hcDBIO);
    paramEditor.putBoolean("KEY_HC_DB_THR", WXHardCoderJNI.hcDBThr);
    paramEditor.putInt("KEY_HC_DB_TIMEOUT", WXHardCoderJNI.hcDBTimeout);
    paramEditor.putInt("KEY_HC_DB_TIMEOUT", WXHardCoderJNI.hcDBTimeoutBusy);
    paramEditor.putLong("KEY_HC_DB_ACTION_QUERY", WXHardCoderJNI.hcDBActionQuery);
    paramEditor.putLong("KEY_HC_DB_ACTION_WRITE", WXHardCoderJNI.hcDBActionWrite);
    paramEditor.putBoolean("KEY_HC_ENCODE_VIDEO_ENABLE", WXHardCoderJNI.hcEncodeVideoEnable);
    paramEditor.putInt("KEY_HC_ENCODE_VIDEO_DELEY", WXHardCoderJNI.hcEncodeVideoDelay);
    paramEditor.putInt("KEY_HC_ENCODE_VIDEO_CPU", WXHardCoderJNI.hcEncodeVideoCPU);
    paramEditor.putInt("KEY_HC_ENCODE_VIDEO_IO", WXHardCoderJNI.hcEncodeVideoIO);
    paramEditor.putBoolean("KEY_HC_ENCODE_VIDEO_THR", WXHardCoderJNI.hcEncodeVideoThr);
    paramEditor.putInt("KEY_HC_ENCODE_VIDEO_TIMEOUT", WXHardCoderJNI.hcEncodeVideoTimeout);
    paramEditor.putLong("KEY_HC_ENCODE_VIDEO_ACTION", WXHardCoderJNI.hcEncodeVideoAction);
    paramEditor.putBoolean("KEY_HC_DECODE_PIC_ENABLE", WXHardCoderJNI.hcDecodePicEnable);
    paramEditor.putInt("KEY_HC_DECODE_PIC_DELEY", WXHardCoderJNI.hcDecodePicDelay);
    paramEditor.putInt("KEY_HC_DECODE_PIC_CPU", WXHardCoderJNI.hcDecodePicCPU);
    paramEditor.putInt("KEY_HC_DECODE_PIC_IO", WXHardCoderJNI.hcDecodePicIO);
    paramEditor.putBoolean("KEY_HC_DECODE_PIC_THR", WXHardCoderJNI.hcDecodePicThr);
    paramEditor.putInt("KEY_HC_DECODE_PIC_TIMEOUT", WXHardCoderJNI.hcDecodePicTimeout);
    paramEditor.putLong("KEY_HC_DECODE_PIC_ACTION", WXHardCoderJNI.hcDecodePicAction);
    paramEditor.putBoolean("KEY_HC_GIF_ENABLE", WXHardCoderJNI.hcGifEnable);
    paramEditor.putInt("KEY_HC_GIF_DELEY", WXHardCoderJNI.hcGifDelay);
    paramEditor.putInt("KEY_HC_GIF_CPU", WXHardCoderJNI.hcGifCPU);
    paramEditor.putInt("KEY_HC_GIF_IO", WXHardCoderJNI.hcGifIO);
    paramEditor.putBoolean("KEY_HC_GIF_THR", WXHardCoderJNI.hcGifThr);
    paramEditor.putInt("KEY_HC_GIF_TIMEOUT", WXHardCoderJNI.hcGifTimeout);
    paramEditor.putLong("KEY_HC_GIF_ACTION", WXHardCoderJNI.hcGifAction);
    paramEditor.putBoolean("KEY_HC_GIF_FRAME_ENABLE", WXHardCoderJNI.hcGifFrameEnable);
    paramEditor.putInt("KEY_HC_GIF_FRAME_DELEY", WXHardCoderJNI.hcGifFrameDelay);
    paramEditor.putInt("KEY_HC_GIF_FRAME_CPU", WXHardCoderJNI.hcGifFrameCPU);
    paramEditor.putInt("KEY_HC_GIF_FRAME_IO", WXHardCoderJNI.hcGifFrameIO);
    paramEditor.putBoolean("KEY_HC_GIF_FRAME_THR", WXHardCoderJNI.hcGifFrameThr);
    paramEditor.putInt("KEY_HC_GIF_FRAME_TIMEOUT", WXHardCoderJNI.hcGifFrameTimeout);
    paramEditor.putLong("KEY_HC_GIF_FRAME_ACTION", WXHardCoderJNI.hcGifFrameAction);
    paramEditor.putBoolean("KEY_HC_SNS_SCROLL_ENABLE", WXHardCoderJNI.hcSNSScrollEnable);
    paramEditor.putInt("KEY_HC_SNS_SCROLL_DELEY", WXHardCoderJNI.hcSNSScrollDelay);
    paramEditor.putInt("KEY_HC_SNS_SCROLL_CPU", WXHardCoderJNI.hcSNSScrollCPU);
    paramEditor.putInt("KEY_HC_SNS_SCROLL_IO", WXHardCoderJNI.hcSNSScrollIO);
    paramEditor.putBoolean("KEY_HC_SNS_SCROLL_THR", WXHardCoderJNI.hcSNSScrollThr);
    paramEditor.putInt("KEY_HC_SNS_SCROLL_TIMEOUT", WXHardCoderJNI.hcSNSScrollTimeout);
    paramEditor.putLong("KEY_HC_SNS_SCROLL_ACTION", WXHardCoderJNI.hcSNSScrollAction);
    paramEditor.putBoolean("KEY_HC_SNS_USER_SCROLL_ENABLE", WXHardCoderJNI.hcSNSUserScrollEnable);
    paramEditor.putInt("KEY_HC_SNS_USER_SCROLL_DELEY", WXHardCoderJNI.hcSNSUserScrollDelay);
    paramEditor.putInt("KEY_HC_SNS_USER_SCROLL_CPU", WXHardCoderJNI.hcSNSUserScrollCPU);
    paramEditor.putInt("KEY_HC_SNS_USER_SCROLL_IO", WXHardCoderJNI.hcSNSUserScrollIO);
    paramEditor.putBoolean("KEY_HC_SNS_USER_SCROLL_THR", WXHardCoderJNI.hcSNSUserScrollThr);
    paramEditor.putInt("KEY_HC_SNS_USER_SCROLL_TIMEOUT", WXHardCoderJNI.hcSNSUserScrollTimeout);
    paramEditor.putLong("KEY_HC_SNS_USER_SCROLL_ACTION", WXHardCoderJNI.hcSNSUserScrollAction);
    paramEditor.putBoolean("KEY_HC_SNS_MSG_SCROLL_ENABLE", WXHardCoderJNI.hcSNSMsgScrollEnable);
    paramEditor.putInt("KEY_HC_SNS_MSG_SCROLL_DELEY", WXHardCoderJNI.hcSNSMsgScrollDelay);
    paramEditor.putInt("KEY_HC_SNS_MSG_SCROLL_CPU", WXHardCoderJNI.hcSNSMsgScrollCPU);
    paramEditor.putInt("KEY_HC_SNS_MSG_SCROLL_IO", WXHardCoderJNI.hcSNSMsgScrollIO);
    paramEditor.putBoolean("KEY_HC_SNS_MSG_SCROLL_THR", WXHardCoderJNI.hcSNSMsgScrollThr);
    paramEditor.putInt("KEY_HC_SNS_MSG_SCROLL_TIMEOUT", WXHardCoderJNI.hcSNSMsgScrollTimeout);
    paramEditor.putLong("KEY_HC_SNS_MSG_SCROLL_ACTION", WXHardCoderJNI.hcSNSMsgScrollAction);
    paramEditor.putBoolean("KEY_HC_MEDIA_GALLERY_SCROLL_ENABLE", WXHardCoderJNI.hcMediaGalleryScrollEnable);
    paramEditor.putInt("KEY_HC_MEDIA_GALLERY_SCROLL_DELEY", WXHardCoderJNI.hcMediaGalleryScrollDelay);
    paramEditor.putInt("KEY_HC_MEDIA_GALLERY_SCROLL_CPU", WXHardCoderJNI.hcMediaGalleryScrollCPU);
    paramEditor.putInt("KEY_HC_MEDIA_GALLERY_SCROLL_IO", WXHardCoderJNI.hcMediaGalleryScrollIO);
    paramEditor.putBoolean("KEY_HC_MEDIA_GALLERY_SCROLL_THR", WXHardCoderJNI.hcMediaGalleryScrollThr);
    paramEditor.putInt("KEY_HC_MEDIA_GALLERY_SCROLL_TIMEOUT", WXHardCoderJNI.hcMediaGalleryScrollTimeout);
    paramEditor.putLong("KEY_HC_MEDIA_GALLERY_SCROLL_ACTION", WXHardCoderJNI.hcMediaGalleryScrollAction);
    paramEditor.putBoolean("KEY_HCALBUM_SCROLL_ENABLE", WXHardCoderJNI.hcAlbumScrollEnable);
    paramEditor.putInt("KEY_HC_ALBUM_SCROLL_DELEY", WXHardCoderJNI.hcAlbumScrollDelay);
    paramEditor.putInt("KEY_HC_ALBUM_SCROLL_CPU", WXHardCoderJNI.hcAlbumScrollCPU);
    paramEditor.putInt("KEY_HC_ALBUM_SCROLL_IO", WXHardCoderJNI.hcAlbumScrollIO);
    paramEditor.putBoolean("KEY_HC_ALBUM_SCROLL_THR", WXHardCoderJNI.hcAlbumScrollThr);
    paramEditor.putInt("KEY_HC_ALBUM_SCROLL_TIMEOUT", WXHardCoderJNI.hcAlbumScrollTimeout);
    paramEditor.putLong("KEY_HC_ALBUM_SCROLL_ACTION", WXHardCoderJNI.hcAlbumScrollAction);
    paramEditor.apply();
    AppMethodBeat.o(39068);
  }
  
  private static String h(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39069);
    String str1 = ad.g(paramContext.getSharedPreferences(ak.fow(), 0));
    String str2 = ad.fom();
    if ((!str1.equalsIgnoreCase("zh_CN")) && ((!str1.equalsIgnoreCase("language_default")) || (!"zh_CN".equalsIgnoreCase(str2))))
    {
      paramContext = DateFormat.getTimeInstance(3, ad.aRN(str1)).format(new Time(paramInt1, paramInt2, 0));
      AppMethodBeat.o(39069);
      return paramContext;
    }
    if (paramInt1 > 12) {}
    for (int i = paramInt1 - 12;; i = paramInt1)
    {
      paramContext = i.v(paramContext, paramInt1 * 3600000L + paramInt2 * 60000L) + String.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(39069);
      return paramContext;
    }
  }
  
  public int getLayoutId()
  {
    return 2131494430;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39065);
    super.onCreate(paramBundle);
    setMMTitle(2131763241);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(39059);
        HardCoderSettingUI.this.finish();
        AppMethodBeat.o(39059);
        return true;
      }
    });
    paramBundle = getContext().getSharedPreferences("hardcoder_setting", 0);
    if (!paramBundle.contains("KEY_HC_ENABLE")) {
      b(paramBundle.edit().putBoolean("KEY_HC_ENABLE", true));
    }
    this.LbS = ((CheckBox)findViewById(2131298223));
    this.LbS.setChecked(WXHardCoderJNI.getDebug());
    this.LbQ = ((CheckBox)findViewById(2131298229));
    this.LbQ.setChecked(WXHardCoderJNI.getEnable());
    this.LbR = ((EditText)findViewById(2131304148));
    this.LbR.setText(WXHardCoderJNI.hcRetryInterval);
    this.LbT = ((CheckBox)findViewById(2131298221));
    this.LbU = ((CheckBox)findViewById(2131298225));
    this.LbU.setChecked(WXHardCoderJNI.hcTimeLimit);
    this.LbV = ((TextView)findViewById(2131297199));
    this.LbW = ((TextView)findViewById(2131299490));
    this.LbV.setText(h(this, WXHardCoderJNI.hcBeginTimeHour, WXHardCoderJNI.hcBeginTimeMin));
    this.LbW.setText(h(this, WXHardCoderJNI.hcEndTimeHour, WXHardCoderJNI.hcEndTimeMin));
    this.LbV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(39060);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/HardCoderSettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        HardCoderSettingUI.a(HardCoderSettingUI.this, true);
        HardCoderSettingUI.this.showDialog(1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/HardCoderSettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(39060);
      }
    });
    this.LbW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(39061);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/HardCoderSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        HardCoderSettingUI.a(HardCoderSettingUI.this, false);
        HardCoderSettingUI.this.showDialog(1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/HardCoderSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(39061);
      }
    });
    this.LbX = ((CheckBox)findViewById(2131298218));
    this.LbX.setChecked(WXHardCoderJNI.hcBootEnable);
    this.LbY = ((EditText)findViewById(2131298965));
    this.LbY.setText(WXHardCoderJNI.hcBootDelay);
    this.LbZ = ((EditText)findViewById(2131305827));
    this.LbZ.setText(WXHardCoderJNI.hcBootTimeout);
    this.LbZ.setSelection(this.LbZ.getText().length());
    this.Lca = ((EditText)findViewById(2131296353));
    this.Lca.setText(WXHardCoderJNI.hcBootAction);
    this.Lcb = ((Spinner)findViewById(2131298836));
    this.Lcb.setSelection(WXHardCoderJNI.hcBootCPU);
    this.Lcc = ((Spinner)findViewById(2131301102));
    this.Lcc.setSelection(WXHardCoderJNI.hcBootIO);
    this.Lcd = ((CheckBox)findViewById(2131305775));
    this.Lcd.setChecked(WXHardCoderJNI.hcBootThr);
    this.Lce = ((CheckBox)findViewById(2131298226));
    this.Lce.setChecked(WXHardCoderJNI.hcEnterChattingEnable);
    this.Lcf = ((EditText)findViewById(2131298969));
    this.Lcf.setText(WXHardCoderJNI.hcEnterChattingDelay);
    this.Lcg = ((EditText)findViewById(2131305831));
    this.Lcg.setText(WXHardCoderJNI.hcEnterChattingTimeout);
    this.Lcg.setSelection(this.Lcg.getText().length());
    this.Lch = ((EditText)findViewById(2131296363));
    this.Lch.setText(WXHardCoderJNI.hcEnterChattingAction);
    this.Lci = ((Spinner)findViewById(2131298839));
    this.Lci.setSelection(WXHardCoderJNI.hcEnterChattingCPU);
    this.Lcj = ((Spinner)findViewById(2131301105));
    this.Lcj.setSelection(WXHardCoderJNI.hcEnterChattingIO);
    this.Lck = ((CheckBox)findViewById(2131305778));
    this.Lck.setChecked(WXHardCoderJNI.hcEnterChattingThr);
    this.Lcl = ((CheckBox)findViewById(2131298236));
    this.Lcl.setChecked(WXHardCoderJNI.hcQuitChattingEnable);
    this.Lcm = ((EditText)findViewById(2131298973));
    this.Lcm.setText(WXHardCoderJNI.hcQuitChattingDelay);
    this.Lcn = ((EditText)findViewById(2131305835));
    this.Lcn.setText(WXHardCoderJNI.hcQuitChattingTimeout);
    this.Lcn.setSelection(this.Lcn.getText().length());
    this.Lco = ((EditText)findViewById(2131296378));
    this.Lco.setText(WXHardCoderJNI.hcQuitChattingAction);
    this.Lcp = ((Spinner)findViewById(2131298843));
    this.Lcp.setSelection(WXHardCoderJNI.hcQuitChattingCPU);
    this.Lcq = ((Spinner)findViewById(2131301109));
    this.Lcq.setSelection(WXHardCoderJNI.hcQuitChattingIO);
    this.Lcr = ((CheckBox)findViewById(2131305782));
    this.Lcr.setChecked(WXHardCoderJNI.hcQuitChattingThr);
    this.Lcs = ((CheckBox)findViewById(2131298239));
    this.Lcs.setChecked(WXHardCoderJNI.hcSendMsgEnable);
    this.Lct = ((EditText)findViewById(2131298975));
    this.Lct.setText(WXHardCoderJNI.hcSendMsgDelay);
    this.Lcu = ((EditText)findViewById(2131305837));
    this.Lcu.setText(WXHardCoderJNI.hcSendMsgTimeout);
    this.Lcu.setSelection(this.Lcu.getText().length());
    this.Lcv = ((EditText)findViewById(2131296381));
    this.Lcv.setText(WXHardCoderJNI.hcSendMsgAction);
    this.Lcw = ((Spinner)findViewById(2131298845));
    this.Lcw.setSelection(WXHardCoderJNI.hcSendMsgCPU);
    this.Lcx = ((Spinner)findViewById(2131301111));
    this.Lcx.setSelection(WXHardCoderJNI.hcSendMsgIO);
    this.Lcy = ((CheckBox)findViewById(2131305784));
    this.Lcy.setChecked(WXHardCoderJNI.hcSendMsgThr);
    this.Lcz = ((CheckBox)findViewById(2131298240));
    this.Lcz.setChecked(WXHardCoderJNI.hcSendPicMsgEnable);
    this.LcA = ((EditText)findViewById(2131298976));
    this.LcA.setText(WXHardCoderJNI.hcSendPicMsgDelay);
    this.LcB = ((EditText)findViewById(2131305838));
    this.LcB.setText(WXHardCoderJNI.hcSendPicMsgTimeout);
    this.LcB.setSelection(this.LcB.getText().length());
    this.LcC = ((EditText)findViewById(2131296382));
    this.LcC.setText(WXHardCoderJNI.hcSendPicMsgAction);
    this.LcD = ((Spinner)findViewById(2131298846));
    this.LcD.setSelection(WXHardCoderJNI.hcSendPicMsgCPU);
    this.LcE = ((Spinner)findViewById(2131301112));
    this.LcE.setSelection(WXHardCoderJNI.hcSendPicMsgIO);
    this.LcF = ((CheckBox)findViewById(2131305785));
    this.LcF.setChecked(WXHardCoderJNI.hcSendPicMsgThr);
    this.LcG = ((CheckBox)findViewById(2131298237));
    this.LcG.setChecked(WXHardCoderJNI.hcReceiveMsgEnable);
    this.LcH = ((EditText)findViewById(2131298974));
    this.LcH.setText(WXHardCoderJNI.hcReceiveMsgDelay);
    this.LcI = ((EditText)findViewById(2131305836));
    this.LcI.setText(WXHardCoderJNI.hcReceiveMsgTimeout);
    this.LcI.setSelection(this.LcI.getText().length());
    this.LcJ = ((EditText)findViewById(2131296379));
    this.LcJ.setText(WXHardCoderJNI.hcReceiveMsgAction);
    this.LcK = ((Spinner)findViewById(2131298844));
    this.LcK.setSelection(WXHardCoderJNI.hcReceiveMsgCPU);
    this.LcL = ((Spinner)findViewById(2131301110));
    this.LcL.setSelection(WXHardCoderJNI.hcReceiveMsgIO);
    this.LcM = ((CheckBox)findViewById(2131305783));
    this.LcM.setChecked(WXHardCoderJNI.hcReceiveMsgThr);
    this.LcN = ((CheckBox)findViewById(2131298253));
    this.LcN.setChecked(WXHardCoderJNI.hcUpdateChatroomEnable);
    this.LcO = ((EditText)findViewById(2131298980));
    this.LcO.setText(WXHardCoderJNI.hcUpdateChatroomDelay);
    this.LcP = ((EditText)findViewById(2131305842));
    this.LcP.setText(WXHardCoderJNI.hcUpdateChatroomTimeout);
    this.LcP.setSelection(this.LcP.getText().length());
    this.LcQ = ((EditText)findViewById(2131296392));
    this.LcQ.setText(WXHardCoderJNI.hcUpdateChatroomAction);
    this.LcR = ((Spinner)findViewById(2131298850));
    this.LcR.setSelection(WXHardCoderJNI.hcUpdateChatroomCPU);
    this.LcS = ((Spinner)findViewById(2131301116));
    this.LcS.setSelection(WXHardCoderJNI.hcUpdateChatroomIO);
    this.LcT = ((CheckBox)findViewById(2131305789));
    this.LcT.setChecked(WXHardCoderJNI.hcUpdateChatroomThr);
    this.LcU = ((EditText)findViewById(2131306202));
    this.LcU.setText(WXHardCoderJNI.hcUpdateChatroomMemberCount);
    this.LcV = ((CheckBox)findViewById(2131298222));
    this.LcV.setChecked(WXHardCoderJNI.hcDBEnable);
    this.LcW = ((EditText)findViewById(2131298966));
    this.LcW.setText(WXHardCoderJNI.hcDBDelayQuery);
    this.LcX = ((EditText)findViewById(2131298967));
    this.LcX.setText(WXHardCoderJNI.hcDBDelayWrite);
    this.LcY = ((EditText)findViewById(2131305828));
    this.LcY.setText(WXHardCoderJNI.hcDBTimeout);
    this.LcZ = ((EditText)findViewById(2131305829));
    this.LcZ.setText(WXHardCoderJNI.hcDBTimeoutBusy);
    this.Lda = ((EditText)findViewById(2131296358));
    this.Lda.setText(WXHardCoderJNI.hcDBActionQuery);
    this.Ldb = ((EditText)findViewById(2131296359));
    this.Ldb.setText(WXHardCoderJNI.hcDBActionWrite);
    this.Ldc = ((Spinner)findViewById(2131298837));
    this.Ldc.setSelection(WXHardCoderJNI.hcDBCPU);
    this.Ldd = ((Spinner)findViewById(2131301103));
    this.Ldd.setSelection(WXHardCoderJNI.hcDBIO);
    this.Lde = ((CheckBox)findViewById(2131305776));
    this.Lde.setChecked(WXHardCoderJNI.hcDBThr);
    this.Ldf = ((CheckBox)findViewById(2131298254));
    this.Ldf.setChecked(WXHardCoderJNI.hcEncodeVideoEnable);
    this.Ldg = ((EditText)findViewById(2131298981));
    this.Ldg.setText(WXHardCoderJNI.hcEncodeVideoDelay);
    this.Ldh = ((EditText)findViewById(2131305843));
    this.Ldh.setText(WXHardCoderJNI.hcEncodeVideoTimeout);
    this.Ldi = ((EditText)findViewById(2131296393));
    this.Ldi.setText(WXHardCoderJNI.hcEncodeVideoAction);
    this.Ldj = ((Spinner)findViewById(2131298851));
    this.Ldj.setSelection(WXHardCoderJNI.hcEncodeVideoCPU);
    this.Ldk = ((Spinner)findViewById(2131301117));
    this.Ldk.setSelection(WXHardCoderJNI.hcEncodeVideoIO);
    this.Ldl = ((CheckBox)findViewById(2131305790));
    this.Ldl.setChecked(WXHardCoderJNI.hcEncodeVideoThr);
    this.Ldm = ((CheckBox)findViewById(2131298224));
    this.Ldm.setChecked(WXHardCoderJNI.hcDecodePicEnable);
    this.Ldn = ((EditText)findViewById(2131298968));
    this.Ldn.setText(WXHardCoderJNI.hcDecodePicDelay);
    this.Ldo = ((EditText)findViewById(2131305830));
    this.Ldo.setText(WXHardCoderJNI.hcDecodePicTimeout);
    this.Ldp = ((EditText)findViewById(2131296360));
    this.Ldp.setText(WXHardCoderJNI.hcDecodePicAction);
    this.Ldq = ((Spinner)findViewById(2131298838));
    this.Ldq.setSelection(WXHardCoderJNI.hcDecodePicCPU);
    this.Ldr = ((Spinner)findViewById(2131301104));
    this.Ldr.setSelection(WXHardCoderJNI.hcDecodePicIO);
    this.Lds = ((CheckBox)findViewById(2131305777));
    this.Lds.setChecked(WXHardCoderJNI.hcDecodePicThr);
    this.Ldt = ((CheckBox)findViewById(2131298227));
    this.Ldt.setChecked(WXHardCoderJNI.hcGifEnable);
    this.Ldu = ((EditText)findViewById(2131298970));
    this.Ldu.setText(WXHardCoderJNI.hcGifDelay);
    this.Ldv = ((EditText)findViewById(2131305832));
    this.Ldv.setText(WXHardCoderJNI.hcGifTimeout);
    this.Ldw = ((EditText)findViewById(2131296364));
    this.Ldw.setText(WXHardCoderJNI.hcGifAction);
    this.Ldx = ((Spinner)findViewById(2131298840));
    this.Ldx.setSelection(WXHardCoderJNI.hcGifCPU);
    this.Ldy = ((Spinner)findViewById(2131301106));
    this.Ldy.setSelection(WXHardCoderJNI.hcGifIO);
    this.Ldz = ((CheckBox)findViewById(2131305779));
    this.Ldz.setChecked(WXHardCoderJNI.hcGifThr);
    this.LdA = ((CheckBox)findViewById(2131298228));
    this.LdA.setChecked(WXHardCoderJNI.hcGifFrameEnable);
    this.LdB = ((EditText)findViewById(2131298971));
    this.LdB.setText(WXHardCoderJNI.hcGifFrameDelay);
    this.LdC = ((EditText)findViewById(2131305833));
    this.LdC.setText(WXHardCoderJNI.hcGifFrameTimeout);
    this.LdD = ((EditText)findViewById(2131296365));
    this.LdD.setText(WXHardCoderJNI.hcGifFrameAction);
    this.LdE = ((Spinner)findViewById(2131298841));
    this.LdE.setSelection(WXHardCoderJNI.hcGifFrameCPU);
    this.LdF = ((Spinner)findViewById(2131301107));
    this.LdF.setSelection(WXHardCoderJNI.hcGifFrameIO);
    this.LdG = ((CheckBox)findViewById(2131305780));
    this.LdG.setChecked(WXHardCoderJNI.hcGifFrameThr);
    this.LdH = ((CheckBox)findViewById(2131298244));
    this.LdH.setChecked(WXHardCoderJNI.hcSNSScrollEnable);
    this.LdI = ((EditText)findViewById(2131298978));
    this.LdI.setText(WXHardCoderJNI.hcSNSScrollDelay);
    this.LdJ = ((EditText)findViewById(2131305840));
    this.LdJ.setText(WXHardCoderJNI.hcSNSScrollTimeout);
    this.LdK = ((EditText)findViewById(2131296385));
    this.LdK.setText(WXHardCoderJNI.hcSNSScrollAction);
    this.LdL = ((Spinner)findViewById(2131298848));
    this.LdL.setSelection(WXHardCoderJNI.hcSNSScrollCPU);
    this.LdM = ((Spinner)findViewById(2131301114));
    this.LdM.setSelection(WXHardCoderJNI.hcSNSScrollIO);
    this.LdN = ((CheckBox)findViewById(2131305787));
    this.LdN.setChecked(WXHardCoderJNI.hcSNSScrollThr);
    this.LdO = ((CheckBox)findViewById(2131298245));
    this.LdO.setChecked(WXHardCoderJNI.hcSNSUserScrollEnable);
    this.LdP = ((EditText)findViewById(2131298979));
    this.LdP.setText(WXHardCoderJNI.hcSNSUserScrollDelay);
    this.LdQ = ((EditText)findViewById(2131305841));
    this.LdQ.setText(WXHardCoderJNI.hcSNSUserScrollTimeout);
    this.LdR = ((EditText)findViewById(2131296386));
    this.LdR.setText(WXHardCoderJNI.hcSNSUserScrollAction);
    this.LdS = ((Spinner)findViewById(2131298849));
    this.LdS.setSelection(WXHardCoderJNI.hcSNSUserScrollCPU);
    this.LdT = ((Spinner)findViewById(2131301115));
    this.LdT.setSelection(WXHardCoderJNI.hcSNSUserScrollIO);
    this.LdU = ((CheckBox)findViewById(2131305788));
    this.LdU.setChecked(WXHardCoderJNI.hcSNSUserScrollThr);
    this.LdV = ((CheckBox)findViewById(2131298243));
    this.LdV.setChecked(WXHardCoderJNI.hcSNSMsgScrollEnable);
    this.LdW = ((EditText)findViewById(2131298977));
    this.LdW.setText(WXHardCoderJNI.hcSNSMsgScrollDelay);
    this.LdX = ((EditText)findViewById(2131305839));
    this.LdX.setText(WXHardCoderJNI.hcSNSMsgScrollTimeout);
    this.LdY = ((EditText)findViewById(2131296384));
    this.LdY.setText(WXHardCoderJNI.hcSNSMsgScrollAction);
    this.LdZ = ((Spinner)findViewById(2131298847));
    this.LdZ.setSelection(WXHardCoderJNI.hcSNSMsgScrollCPU);
    this.Lea = ((Spinner)findViewById(2131301113));
    this.Lea.setSelection(WXHardCoderJNI.hcSNSMsgScrollIO);
    this.Leb = ((CheckBox)findViewById(2131305786));
    this.Leb.setChecked(WXHardCoderJNI.hcSNSMsgScrollThr);
    this.Lec = ((CheckBox)findViewById(2131298231));
    this.Lec.setChecked(WXHardCoderJNI.hcMediaGalleryScrollEnable);
    this.Led = ((EditText)findViewById(2131298972));
    this.Led.setText(WXHardCoderJNI.hcMediaGalleryScrollDelay);
    this.Lee = ((EditText)findViewById(2131305834));
    this.Lee.setText(WXHardCoderJNI.hcMediaGalleryScrollTimeout);
    this.Lef = ((EditText)findViewById(2131296368));
    this.Lef.setText(WXHardCoderJNI.hcMediaGalleryScrollAction);
    this.Leg = ((Spinner)findViewById(2131298842));
    this.Leg.setSelection(WXHardCoderJNI.hcMediaGalleryScrollCPU);
    this.Leh = ((Spinner)findViewById(2131301108));
    this.Leh.setSelection(WXHardCoderJNI.hcMediaGalleryScrollIO);
    this.Lei = ((CheckBox)findViewById(2131305781));
    this.Lei.setChecked(WXHardCoderJNI.hcMediaGalleryScrollThr);
    this.Lej = ((CheckBox)findViewById(2131298216));
    this.Lej.setChecked(WXHardCoderJNI.hcAlbumScrollEnable);
    this.Lek = ((EditText)findViewById(2131298963));
    this.Lek.setText(WXHardCoderJNI.hcAlbumScrollDelay);
    this.Lel = ((EditText)findViewById(2131305825));
    this.Lel.setText(WXHardCoderJNI.hcAlbumScrollTimeout);
    this.Lem = ((EditText)findViewById(2131296342));
    this.Lem.setText(WXHardCoderJNI.hcAlbumScrollAction);
    this.Len = ((Spinner)findViewById(2131298834));
    this.Len.setSelection(WXHardCoderJNI.hcAlbumScrollCPU);
    this.Leo = ((Spinner)findViewById(2131301100));
    this.Leo.setSelection(WXHardCoderJNI.hcAlbumScrollIO);
    this.Lep = ((CheckBox)findViewById(2131305773));
    this.Lep.setChecked(WXHardCoderJNI.hcAlbumScrollThr);
    this.Leq = ((CheckBox)findViewById(2131298217));
    this.Leq.setChecked(WXHardCoderJNI.hcBizEnable);
    this.Ler = ((EditText)findViewById(2131298964));
    this.Ler.setText(WXHardCoderJNI.hcBizDelay);
    this.Les = ((EditText)findViewById(2131305826));
    this.Les.setText(WXHardCoderJNI.hcBizTimeout);
    this.Let = ((EditText)findViewById(2131296352));
    this.Let.setText(WXHardCoderJNI.hcBizAction);
    this.Leu = ((Spinner)findViewById(2131298835));
    this.Leu.setSelection(WXHardCoderJNI.hcBizCPU);
    this.Lev = ((Spinner)findViewById(2131301101));
    this.Lev.setSelection(WXHardCoderJNI.hcBizIO);
    this.Lew = ((CheckBox)findViewById(2131305774));
    this.Lew.setChecked(WXHardCoderJNI.hcBizThr);
    this.LbQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(39062);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/HardCoderSettingUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        boolean bool = HardCoderSettingUI.a(HardCoderSettingUI.this).isChecked();
        HardCoderSettingUI.b(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.c(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.d(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.e(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.f(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.g(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.h(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.i(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.j(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.k(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.l(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.m(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.n(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.o(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.p(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.q(HardCoderSettingUI.this).setChecked(bool);
        HardCoderSettingUI.r(HardCoderSettingUI.this).setChecked(bool);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/HardCoderSettingUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(39062);
      }
    });
    AppMethodBeat.o(39065);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(39066);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(39066);
      return null;
    }
    if (this.yWr)
    {
      localTimePickerDialog = new TimePickerDialog(getContext(), this.yWs, WXHardCoderJNI.hcBeginTimeHour, WXHardCoderJNI.hcBeginTimeMin, false);
      AppMethodBeat.o(39066);
      return localTimePickerDialog;
    }
    TimePickerDialog localTimePickerDialog = new TimePickerDialog(getContext(), this.yWs, WXHardCoderJNI.hcEndTimeHour, WXHardCoderJNI.hcBeginTimeMin, false);
    AppMethodBeat.o(39066);
    return localTimePickerDialog;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39067);
    ae.i("HardCoderSettingUI", "save");
    if ((this.LbQ.isChecked()) && (!WXHardCoderJNI.getEnable()))
    {
      WXHardCoderJNI.setHcEnable(this.LbQ.isChecked());
      WXHardCoderJNI.initHardCoder(com.tencent.mm.plugin.hardcoder.a.deO(), com.tencent.mm.plugin.hardcoder.a.deO(), null);
    }
    WXHardCoderJNI.setDebug(this.LbS.isChecked());
    WXHardCoderJNI.setHcEnable(this.LbQ.isChecked());
    WXHardCoderJNI.hcRetryInterval = bu.getInt(this.LbR.getText().toString(), WXHardCoderJNI.hcRetryInterval);
    if (WXHardCoderJNI.isCheckEnv())
    {
      WXHardCoderJNI.setDebug(WXHardCoderJNI.getDebug());
      WXHardCoderJNI.setHcEnable(WXHardCoderJNI.getEnable());
      WXHardCoderJNI.setRetryConnectInterval(WXHardCoderJNI.hcRetryInterval);
    }
    WXHardCoderJNI.hcTimeLimit = this.LbU.isChecked();
    WXHardCoderJNI.hcBootEnable = this.LbX.isChecked();
    WXHardCoderJNI.hcBootDelay = bu.getInt(this.LbY.getText().toString(), WXHardCoderJNI.hcBootDelay);
    WXHardCoderJNI.hcBootCPU = this.Lcb.getSelectedItemPosition();
    WXHardCoderJNI.hcBootIO = this.Lcc.getSelectedItemPosition();
    WXHardCoderJNI.hcBootThr = this.Lcd.isChecked();
    WXHardCoderJNI.hcBootTimeout = bu.getInt(this.LbZ.getText().toString(), WXHardCoderJNI.hcBootTimeout);
    WXHardCoderJNI.hcBootAction = bu.getLong(this.Lca.getText().toString(), WXHardCoderJNI.hcBootAction);
    WXHardCoderJNI.hcEnterChattingEnable = this.Lce.isChecked();
    WXHardCoderJNI.hcEnterChattingDelay = bu.getInt(this.Lcf.getText().toString(), WXHardCoderJNI.hcEnterChattingDelay);
    WXHardCoderJNI.hcEnterChattingCPU = this.Lci.getSelectedItemPosition();
    WXHardCoderJNI.hcEnterChattingIO = this.Lcj.getSelectedItemPosition();
    WXHardCoderJNI.hcEnterChattingThr = this.Lck.isChecked();
    WXHardCoderJNI.hcEnterChattingTimeout = bu.getInt(this.Lcg.getText().toString(), WXHardCoderJNI.hcEnterChattingTimeout);
    WXHardCoderJNI.hcEnterChattingAction = bu.getLong(this.Lch.getText().toString(), WXHardCoderJNI.hcEnterChattingAction);
    WXHardCoderJNI.hcQuitChattingEnable = this.Lcl.isChecked();
    WXHardCoderJNI.hcQuitChattingDelay = bu.getInt(this.Lcm.getText().toString(), WXHardCoderJNI.hcQuitChattingDelay);
    WXHardCoderJNI.hcQuitChattingCPU = this.Lcp.getSelectedItemPosition();
    WXHardCoderJNI.hcQuitChattingIO = this.Lcq.getSelectedItemPosition();
    WXHardCoderJNI.hcQuitChattingThr = this.Lcr.isChecked();
    WXHardCoderJNI.hcQuitChattingTimeout = bu.getInt(this.Lcn.getText().toString(), WXHardCoderJNI.hcQuitChattingTimeout);
    WXHardCoderJNI.hcQuitChattingAction = bu.getLong(this.Lco.getText().toString(), WXHardCoderJNI.hcQuitChattingAction);
    WXHardCoderJNI.hcSendMsgEnable = this.Lcs.isChecked();
    WXHardCoderJNI.hcSendMsgDelay = bu.getInt(this.Lct.getText().toString(), WXHardCoderJNI.hcSendMsgDelay);
    WXHardCoderJNI.hcSendMsgCPU = this.Lcw.getSelectedItemPosition();
    WXHardCoderJNI.hcSendMsgIO = this.Lcx.getSelectedItemPosition();
    WXHardCoderJNI.hcSendMsgThr = this.Lcy.isChecked();
    WXHardCoderJNI.hcSendMsgTimeout = bu.getInt(this.Lcu.getText().toString(), WXHardCoderJNI.hcSendMsgTimeout);
    WXHardCoderJNI.hcSendMsgAction = bu.getLong(this.Lcv.getText().toString(), WXHardCoderJNI.hcSendMsgAction);
    WXHardCoderJNI.hcSendPicMsgEnable = this.Lcz.isChecked();
    WXHardCoderJNI.hcSendPicMsgDelay = bu.getInt(this.LcA.getText().toString(), WXHardCoderJNI.hcSendPicMsgDelay);
    WXHardCoderJNI.hcSendPicMsgCPU = this.LcD.getSelectedItemPosition();
    WXHardCoderJNI.hcSendPicMsgIO = this.LcE.getSelectedItemPosition();
    WXHardCoderJNI.hcSendPicMsgThr = this.LcF.isChecked();
    WXHardCoderJNI.hcSendPicMsgTimeout = bu.getInt(this.LcB.getText().toString(), WXHardCoderJNI.hcSendPicMsgTimeout);
    WXHardCoderJNI.hcSendPicMsgAction = bu.getLong(this.LcC.getText().toString(), WXHardCoderJNI.hcSendPicMsgAction);
    WXHardCoderJNI.hcReceiveMsgEnable = this.LcG.isChecked();
    WXHardCoderJNI.hcReceiveMsgDelay = bu.getInt(this.LcH.getText().toString(), WXHardCoderJNI.hcReceiveMsgDelay);
    WXHardCoderJNI.hcReceiveMsgCPU = this.LcK.getSelectedItemPosition();
    WXHardCoderJNI.hcReceiveMsgIO = this.LcL.getSelectedItemPosition();
    WXHardCoderJNI.hcReceiveMsgThr = this.LcM.isChecked();
    WXHardCoderJNI.hcReceiveMsgTimeout = bu.getInt(this.LcI.getText().toString(), WXHardCoderJNI.hcReceiveMsgTimeout);
    WXHardCoderJNI.hcReceiveMsgAction = bu.getLong(this.LcJ.getText().toString(), WXHardCoderJNI.hcReceiveMsgAction);
    WXHardCoderJNI.hcUpdateChatroomEnable = this.LcN.isChecked();
    WXHardCoderJNI.hcUpdateChatroomDelay = bu.getInt(this.LcO.getText().toString(), WXHardCoderJNI.hcUpdateChatroomDelay);
    WXHardCoderJNI.hcUpdateChatroomCPU = this.LcR.getSelectedItemPosition();
    WXHardCoderJNI.hcUpdateChatroomIO = this.LcS.getSelectedItemPosition();
    WXHardCoderJNI.hcUpdateChatroomThr = this.LcT.isChecked();
    WXHardCoderJNI.hcUpdateChatroomTimeout = bu.getInt(this.LcP.getText().toString(), WXHardCoderJNI.hcUpdateChatroomTimeout);
    WXHardCoderJNI.hcUpdateChatroomAction = bu.getLong(this.LcQ.getText().toString(), WXHardCoderJNI.hcUpdateChatroomAction);
    WXHardCoderJNI.hcUpdateChatroomMemberCount = bu.getLong(this.LcU.getText().toString(), WXHardCoderJNI.hcUpdateChatroomMemberCount);
    WXHardCoderJNI.hcDBEnable = this.LcV.isChecked();
    WXHardCoderJNI.hcDBDelayQuery = bu.getInt(this.LcW.getText().toString(), WXHardCoderJNI.hcDBDelayQuery);
    WXHardCoderJNI.hcDBDelayWrite = bu.getInt(this.LcX.getText().toString(), WXHardCoderJNI.hcDBDelayWrite);
    WXHardCoderJNI.hcDBCPU = this.Lcb.getSelectedItemPosition();
    WXHardCoderJNI.hcDBIO = this.Lcc.getSelectedItemPosition();
    WXHardCoderJNI.hcDBThr = this.Lcd.isChecked();
    WXHardCoderJNI.hcDBTimeout = bu.getInt(this.LcY.getText().toString(), WXHardCoderJNI.hcDBTimeout);
    WXHardCoderJNI.hcDBTimeoutBusy = bu.getInt(this.LcZ.getText().toString(), WXHardCoderJNI.hcDBTimeoutBusy);
    WXHardCoderJNI.hcDBActionQuery = bu.getLong(this.Lda.getText().toString(), WXHardCoderJNI.hcDBActionQuery);
    WXHardCoderJNI.hcDBActionWrite = bu.getLong(this.Ldb.getText().toString(), WXHardCoderJNI.hcDBActionWrite);
    WXHardCoderJNI.hcEncodeVideoEnable = this.Ldf.isChecked();
    WXHardCoderJNI.hcEncodeVideoDelay = bu.getInt(this.Ldg.getText().toString(), WXHardCoderJNI.hcEncodeVideoDelay);
    WXHardCoderJNI.hcEncodeVideoCPU = this.Ldj.getSelectedItemPosition();
    WXHardCoderJNI.hcEncodeVideoIO = this.Ldk.getSelectedItemPosition();
    WXHardCoderJNI.hcEncodeVideoThr = this.Ldl.isChecked();
    WXHardCoderJNI.hcEncodeVideoTimeout = bu.getInt(this.Ldh.getText().toString(), WXHardCoderJNI.hcEncodeVideoTimeout);
    WXHardCoderJNI.hcEncodeVideoAction = bu.getLong(this.Ldi.getText().toString(), WXHardCoderJNI.hcEncodeVideoAction);
    WXHardCoderJNI.hcDecodePicEnable = this.Ldm.isChecked();
    WXHardCoderJNI.hcDecodePicDelay = bu.getInt(this.Ldn.getText().toString(), WXHardCoderJNI.hcDecodePicDelay);
    WXHardCoderJNI.hcDecodePicCPU = this.Ldq.getSelectedItemPosition();
    WXHardCoderJNI.hcDecodePicIO = this.Ldr.getSelectedItemPosition();
    WXHardCoderJNI.hcDecodePicThr = this.Lds.isChecked();
    WXHardCoderJNI.hcDecodePicTimeout = bu.getInt(this.Ldo.getText().toString(), WXHardCoderJNI.hcDecodePicTimeout);
    WXHardCoderJNI.hcDecodePicAction = bu.getLong(this.Ldp.getText().toString(), WXHardCoderJNI.hcDecodePicAction);
    WXHardCoderJNI.hcGifEnable = this.Ldt.isChecked();
    WXHardCoderJNI.hcGifDelay = bu.getInt(this.Ldu.getText().toString(), WXHardCoderJNI.hcGifDelay);
    WXHardCoderJNI.hcGifCPU = this.Ldx.getSelectedItemPosition();
    WXHardCoderJNI.hcGifIO = this.Ldy.getSelectedItemPosition();
    WXHardCoderJNI.hcGifThr = this.Ldz.isChecked();
    WXHardCoderJNI.hcGifTimeout = bu.getInt(this.Ldv.getText().toString(), WXHardCoderJNI.hcGifTimeout);
    WXHardCoderJNI.hcGifAction = bu.getLong(this.Ldw.getText().toString(), WXHardCoderJNI.hcGifAction);
    WXHardCoderJNI.hcGifFrameEnable = this.LdA.isChecked();
    WXHardCoderJNI.hcGifFrameDelay = bu.getInt(this.LdB.getText().toString(), WXHardCoderJNI.hcGifFrameDelay);
    WXHardCoderJNI.hcGifFrameCPU = this.LdE.getSelectedItemPosition();
    WXHardCoderJNI.hcGifFrameIO = this.LdF.getSelectedItemPosition();
    WXHardCoderJNI.hcGifFrameThr = this.LdG.isChecked();
    WXHardCoderJNI.hcGifFrameTimeout = bu.getInt(this.LdC.getText().toString(), WXHardCoderJNI.hcGifFrameTimeout);
    WXHardCoderJNI.hcGifFrameAction = bu.getLong(this.LdD.getText().toString(), WXHardCoderJNI.hcGifFrameAction);
    WXHardCoderJNI.hcSNSScrollEnable = this.LdH.isChecked();
    WXHardCoderJNI.hcSNSScrollDelay = bu.getInt(this.LdI.getText().toString(), WXHardCoderJNI.hcSNSScrollDelay);
    WXHardCoderJNI.hcSNSScrollCPU = this.LdL.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSScrollIO = this.LdM.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSScrollThr = this.LdN.isChecked();
    WXHardCoderJNI.hcSNSScrollTimeout = bu.getInt(this.LdJ.getText().toString(), WXHardCoderJNI.hcSNSScrollTimeout);
    WXHardCoderJNI.hcSNSScrollAction = bu.getLong(this.LdK.getText().toString(), WXHardCoderJNI.hcSNSScrollAction);
    WXHardCoderJNI.hcSNSUserScrollEnable = this.LdO.isChecked();
    WXHardCoderJNI.hcSNSUserScrollDelay = bu.getInt(this.LdP.getText().toString(), WXHardCoderJNI.hcSNSUserScrollDelay);
    WXHardCoderJNI.hcSNSUserScrollCPU = this.LdS.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSUserScrollIO = this.LdT.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSUserScrollThr = this.LdU.isChecked();
    WXHardCoderJNI.hcSNSUserScrollTimeout = bu.getInt(this.LdQ.getText().toString(), WXHardCoderJNI.hcSNSUserScrollTimeout);
    WXHardCoderJNI.hcSNSUserScrollAction = bu.getLong(this.LdR.getText().toString(), WXHardCoderJNI.hcSNSUserScrollAction);
    WXHardCoderJNI.hcSNSMsgScrollEnable = this.LdV.isChecked();
    WXHardCoderJNI.hcSNSMsgScrollDelay = bu.getInt(this.LdW.getText().toString(), WXHardCoderJNI.hcSNSMsgScrollDelay);
    WXHardCoderJNI.hcSNSMsgScrollCPU = this.LdZ.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSMsgScrollIO = this.Lea.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSMsgScrollThr = this.Leb.isChecked();
    WXHardCoderJNI.hcSNSMsgScrollTimeout = bu.getInt(this.LdX.getText().toString(), WXHardCoderJNI.hcSNSMsgScrollTimeout);
    WXHardCoderJNI.hcSNSMsgScrollAction = bu.getLong(this.LdY.getText().toString(), WXHardCoderJNI.hcSNSMsgScrollAction);
    WXHardCoderJNI.hcMediaGalleryScrollEnable = this.Lec.isChecked();
    WXHardCoderJNI.hcMediaGalleryScrollDelay = bu.getInt(this.Led.getText().toString(), WXHardCoderJNI.hcMediaGalleryScrollDelay);
    WXHardCoderJNI.hcMediaGalleryScrollCPU = this.Leg.getSelectedItemPosition();
    WXHardCoderJNI.hcMediaGalleryScrollIO = this.Leh.getSelectedItemPosition();
    WXHardCoderJNI.hcMediaGalleryScrollThr = this.Lei.isChecked();
    WXHardCoderJNI.hcMediaGalleryScrollTimeout = bu.getInt(this.Lee.getText().toString(), WXHardCoderJNI.hcMediaGalleryScrollTimeout);
    WXHardCoderJNI.hcMediaGalleryScrollAction = bu.getLong(this.Lef.getText().toString(), WXHardCoderJNI.hcMediaGalleryScrollAction);
    WXHardCoderJNI.hcAlbumScrollEnable = this.Lej.isChecked();
    WXHardCoderJNI.hcAlbumScrollDelay = bu.getInt(this.Lek.getText().toString(), WXHardCoderJNI.hcAlbumScrollDelay);
    WXHardCoderJNI.hcAlbumScrollCPU = this.Len.getSelectedItemPosition();
    WXHardCoderJNI.hcAlbumScrollIO = this.Leo.getSelectedItemPosition();
    WXHardCoderJNI.hcAlbumScrollThr = this.Lep.isChecked();
    WXHardCoderJNI.hcAlbumScrollTimeout = bu.getInt(this.Lel.getText().toString(), WXHardCoderJNI.hcAlbumScrollTimeout);
    WXHardCoderJNI.hcAlbumScrollAction = bu.getLong(this.Lem.getText().toString(), WXHardCoderJNI.hcAlbumScrollAction);
    WXHardCoderJNI.hcBizEnable = this.Leq.isChecked();
    WXHardCoderJNI.hcBizDelay = bu.getInt(this.Ler.getText().toString(), WXHardCoderJNI.hcBizDelay);
    WXHardCoderJNI.hcBizCPU = this.Leu.getSelectedItemPosition();
    WXHardCoderJNI.hcBizIO = this.Lev.getSelectedItemPosition();
    WXHardCoderJNI.hcBizThr = this.Lew.isChecked();
    WXHardCoderJNI.hcBizTimeout = bu.getInt(this.Les.getText().toString(), WXHardCoderJNI.hcBizTimeout);
    WXHardCoderJNI.hcBizAction = bu.getLong(this.Let.getText().toString(), WXHardCoderJNI.hcBizAction);
    b(getContext().getSharedPreferences("hardcoder_setting", 0).edit());
    WXHardCoderJNI.reloadSPConfig(WXHardCoderJNI.RELOAD_SCENE_SETTING);
    super.onDestroy();
    AppMethodBeat.o(39067);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.HardCoderSettingUI
 * JD-Core Version:    0.7.0.1
 */