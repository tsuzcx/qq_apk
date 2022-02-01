package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.sql.Time;
import java.text.DateFormat;

public class HardCoderSettingUI
  extends MMActivity
{
  private boolean JgH;
  private final TimePickerDialog.OnTimeSetListener JgI;
  private EditText XPA;
  private EditText XPB;
  private Spinner XPC;
  private Spinner XPD;
  private CheckBox XPE;
  private CheckBox XPF;
  private EditText XPG;
  private EditText XPH;
  private EditText XPI;
  private Spinner XPJ;
  private Spinner XPK;
  private CheckBox XPL;
  private CheckBox XPM;
  private EditText XPN;
  private EditText XPO;
  private EditText XPP;
  private Spinner XPQ;
  private Spinner XPR;
  private CheckBox XPS;
  private CheckBox XPT;
  private EditText XPU;
  private EditText XPV;
  private EditText XPW;
  private Spinner XPX;
  private Spinner XPY;
  private CheckBox XPZ;
  private CheckBox XPe;
  private EditText XPf;
  private CheckBox XPg;
  private CheckBox XPh;
  private CheckBox XPi;
  private TextView XPj;
  private CheckBox XPk;
  private EditText XPl;
  private EditText XPm;
  private EditText XPn;
  private Spinner XPo;
  private Spinner XPp;
  private CheckBox XPq;
  private CheckBox XPr;
  private EditText XPs;
  private EditText XPt;
  private EditText XPu;
  private Spinner XPv;
  private Spinner XPw;
  private CheckBox XPx;
  private CheckBox XPy;
  private EditText XPz;
  private EditText XQA;
  private EditText XQB;
  private EditText XQC;
  private Spinner XQD;
  private Spinner XQE;
  private CheckBox XQF;
  private CheckBox XQG;
  private EditText XQH;
  private EditText XQI;
  private EditText XQJ;
  private Spinner XQK;
  private Spinner XQL;
  private CheckBox XQM;
  private CheckBox XQN;
  private EditText XQO;
  private EditText XQP;
  private EditText XQQ;
  private Spinner XQR;
  private Spinner XQS;
  private CheckBox XQT;
  private CheckBox XQU;
  private EditText XQV;
  private EditText XQW;
  private EditText XQX;
  private Spinner XQY;
  private Spinner XQZ;
  private CheckBox XQa;
  private EditText XQb;
  private EditText XQc;
  private EditText XQd;
  private Spinner XQe;
  private Spinner XQf;
  private CheckBox XQg;
  private EditText XQh;
  private CheckBox XQi;
  private EditText XQj;
  private EditText XQk;
  private EditText XQl;
  private EditText XQm;
  private EditText XQn;
  private EditText XQo;
  private Spinner XQp;
  private Spinner XQq;
  private CheckBox XQr;
  private CheckBox XQs;
  private EditText XQt;
  private EditText XQu;
  private EditText XQv;
  private Spinner XQw;
  private Spinner XQx;
  private CheckBox XQy;
  private CheckBox XQz;
  private Spinner XRA;
  private Spinner XRB;
  private CheckBox XRC;
  private CheckBox XRD;
  private EditText XRE;
  private EditText XRF;
  private EditText XRG;
  private Spinner XRH;
  private Spinner XRI;
  private CheckBox XRJ;
  private CheckBox XRa;
  private CheckBox XRb;
  private EditText XRc;
  private EditText XRd;
  private EditText XRe;
  private Spinner XRf;
  private Spinner XRg;
  private CheckBox XRh;
  private CheckBox XRi;
  private EditText XRj;
  private EditText XRk;
  private EditText XRl;
  private Spinner XRm;
  private Spinner XRn;
  private CheckBox XRo;
  private CheckBox XRp;
  private EditText XRq;
  private EditText XRr;
  private EditText XRs;
  private Spinner XRt;
  private Spinner XRu;
  private CheckBox XRv;
  private CheckBox XRw;
  private EditText XRx;
  private EditText XRy;
  private EditText XRz;
  private TextView wZk;
  
  public HardCoderSettingUI()
  {
    AppMethodBeat.i(39064);
    this.JgH = false;
    this.JgI = new TimePickerDialog.OnTimeSetListener()
    {
      public final void onTimeSet(TimePicker paramAnonymousTimePicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(39063);
        if (HardCoderSettingUI.s(HardCoderSettingUI.this))
        {
          WXHardCoderJNI.hcBeginTimeHour = paramAnonymousInt1;
          WXHardCoderJNI.hcBeginTimeMin = paramAnonymousInt2;
          HardCoderSettingUI.t(HardCoderSettingUI.this).setText(HardCoderSettingUI.q(HardCoderSettingUI.this, WXHardCoderJNI.hcBeginTimeHour, WXHardCoderJNI.hcBeginTimeMin));
          AppMethodBeat.o(39063);
          return;
        }
        WXHardCoderJNI.hcEndTimeHour = paramAnonymousInt1;
        WXHardCoderJNI.hcEndTimeMin = paramAnonymousInt2;
        HardCoderSettingUI.u(HardCoderSettingUI.this).setText(HardCoderSettingUI.q(HardCoderSettingUI.this, WXHardCoderJNI.hcEndTimeHour, WXHardCoderJNI.hcEndTimeMin));
        AppMethodBeat.o(39063);
      }
    };
    AppMethodBeat.o(39064);
  }
  
  private static void c(SharedPreferences.Editor paramEditor)
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
  
  private static String j(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39069);
    String str1 = LocaleUtil.loadApplicationLanguageSettings(paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), paramContext);
    String str2 = LocaleUtil.getApplicationLanguage();
    if ((!str1.equalsIgnoreCase("zh_CN")) && ((!str1.equalsIgnoreCase("language_default")) || (!"zh_CN".equalsIgnoreCase(str2))))
    {
      paramContext = DateFormat.getTimeInstance(3, LocaleUtil.transLanguageToLocale(str1)).format(new Time(paramInt1, paramInt2, 0));
      AppMethodBeat.o(39069);
      return paramContext;
    }
    if (paramInt1 > 12) {}
    for (int i = paramInt1 - 12;; i = paramInt1)
    {
      paramContext = f.x(paramContext, paramInt1 * 3600000L + paramInt2 * 60000L) + String.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(39069);
      return paramContext;
    }
  }
  
  public int getLayoutId()
  {
    return R.i.ehz;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39065);
    super.onCreate(paramBundle);
    setMMTitle(R.l.settings_hardcoder);
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
      c(paramBundle.edit().putBoolean("KEY_HC_ENABLE", true));
    }
    this.XPg = ((CheckBox)findViewById(R.h.dAa));
    this.XPg.setChecked(WXHardCoderJNI.getDebug());
    this.XPe = ((CheckBox)findViewById(R.h.dAg));
    this.XPe.setChecked(WXHardCoderJNI.getEnable());
    this.XPf = ((EditText)findViewById(R.h.dST));
    this.XPf.setText(WXHardCoderJNI.hcRetryInterval);
    this.XPh = ((CheckBox)findViewById(R.h.dzY));
    this.XPi = ((CheckBox)findViewById(R.h.dAc));
    this.XPi.setChecked(WXHardCoderJNI.hcTimeLimit);
    this.XPj = ((TextView)findViewById(R.h.dte));
    this.wZk = ((TextView)findViewById(R.h.end_time));
    this.XPj.setText(j(this, WXHardCoderJNI.hcBeginTimeHour, WXHardCoderJNI.hcBeginTimeMin));
    this.wZk.setText(j(this, WXHardCoderJNI.hcEndTimeHour, WXHardCoderJNI.hcEndTimeMin));
    this.XPj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(39060);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/tools/HardCoderSettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        HardCoderSettingUI.a(HardCoderSettingUI.this, true);
        HardCoderSettingUI.this.showDialog(1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/HardCoderSettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(39060);
      }
    });
    this.wZk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(39061);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/tools/HardCoderSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        HardCoderSettingUI.a(HardCoderSettingUI.this, false);
        HardCoderSettingUI.this.showDialog(1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/HardCoderSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(39061);
      }
    });
    this.XPk = ((CheckBox)findViewById(R.h.dzW));
    this.XPk.setChecked(WXHardCoderJNI.hcBootEnable);
    this.XPl = ((EditText)findViewById(R.h.dDL));
    this.XPl.setText(WXHardCoderJNI.hcBootDelay);
    this.XPm = ((EditText)findViewById(R.h.dXa));
    this.XPm.setText(WXHardCoderJNI.hcBootTimeout);
    this.XPm.setSelection(this.XPm.getText().length());
    this.XPn = ((EditText)findViewById(R.h.dpK));
    this.XPn.setText(WXHardCoderJNI.hcBootAction);
    this.XPo = ((Spinner)findViewById(R.h.dDa));
    this.XPo.setSelection(WXHardCoderJNI.hcBootCPU);
    this.XPp = ((Spinner)findViewById(R.h.dJH));
    this.XPp.setSelection(WXHardCoderJNI.hcBootIO);
    this.XPq = ((CheckBox)findViewById(R.h.dWD));
    this.XPq.setChecked(WXHardCoderJNI.hcBootThr);
    this.XPr = ((CheckBox)findViewById(R.h.dAd));
    this.XPr.setChecked(WXHardCoderJNI.hcEnterChattingEnable);
    this.XPs = ((EditText)findViewById(R.h.dDP));
    this.XPs.setText(WXHardCoderJNI.hcEnterChattingDelay);
    this.XPt = ((EditText)findViewById(R.h.dXe));
    this.XPt.setText(WXHardCoderJNI.hcEnterChattingTimeout);
    this.XPt.setSelection(this.XPt.getText().length());
    this.XPu = ((EditText)findViewById(R.h.dpO));
    this.XPu.setText(WXHardCoderJNI.hcEnterChattingAction);
    this.XPv = ((Spinner)findViewById(R.h.dDd));
    this.XPv.setSelection(WXHardCoderJNI.hcEnterChattingCPU);
    this.XPw = ((Spinner)findViewById(R.h.dJK));
    this.XPw.setSelection(WXHardCoderJNI.hcEnterChattingIO);
    this.XPx = ((CheckBox)findViewById(R.h.dWG));
    this.XPx.setChecked(WXHardCoderJNI.hcEnterChattingThr);
    this.XPy = ((CheckBox)findViewById(R.h.dAi));
    this.XPy.setChecked(WXHardCoderJNI.hcQuitChattingEnable);
    this.XPz = ((EditText)findViewById(R.h.dDT));
    this.XPz.setText(WXHardCoderJNI.hcQuitChattingDelay);
    this.XPA = ((EditText)findViewById(R.h.dXi));
    this.XPA.setText(WXHardCoderJNI.hcQuitChattingTimeout);
    this.XPA.setSelection(this.XPA.getText().length());
    this.XPB = ((EditText)findViewById(R.h.dpS));
    this.XPB.setText(WXHardCoderJNI.hcQuitChattingAction);
    this.XPC = ((Spinner)findViewById(R.h.dDh));
    this.XPC.setSelection(WXHardCoderJNI.hcQuitChattingCPU);
    this.XPD = ((Spinner)findViewById(R.h.dJO));
    this.XPD.setSelection(WXHardCoderJNI.hcQuitChattingIO);
    this.XPE = ((CheckBox)findViewById(R.h.dWK));
    this.XPE.setChecked(WXHardCoderJNI.hcQuitChattingThr);
    this.XPF = ((CheckBox)findViewById(R.h.dAk));
    this.XPF.setChecked(WXHardCoderJNI.hcSendMsgEnable);
    this.XPG = ((EditText)findViewById(R.h.dDV));
    this.XPG.setText(WXHardCoderJNI.hcSendMsgDelay);
    this.XPH = ((EditText)findViewById(R.h.dXk));
    this.XPH.setText(WXHardCoderJNI.hcSendMsgTimeout);
    this.XPH.setSelection(this.XPH.getText().length());
    this.XPI = ((EditText)findViewById(R.h.dpU));
    this.XPI.setText(WXHardCoderJNI.hcSendMsgAction);
    this.XPJ = ((Spinner)findViewById(R.h.dDj));
    this.XPJ.setSelection(WXHardCoderJNI.hcSendMsgCPU);
    this.XPK = ((Spinner)findViewById(R.h.dJQ));
    this.XPK.setSelection(WXHardCoderJNI.hcSendMsgIO);
    this.XPL = ((CheckBox)findViewById(R.h.dWM));
    this.XPL.setChecked(WXHardCoderJNI.hcSendMsgThr);
    this.XPM = ((CheckBox)findViewById(R.h.dAl));
    this.XPM.setChecked(WXHardCoderJNI.hcSendPicMsgEnable);
    this.XPN = ((EditText)findViewById(R.h.dDW));
    this.XPN.setText(WXHardCoderJNI.hcSendPicMsgDelay);
    this.XPO = ((EditText)findViewById(R.h.dXl));
    this.XPO.setText(WXHardCoderJNI.hcSendPicMsgTimeout);
    this.XPO.setSelection(this.XPO.getText().length());
    this.XPP = ((EditText)findViewById(R.h.dpV));
    this.XPP.setText(WXHardCoderJNI.hcSendPicMsgAction);
    this.XPQ = ((Spinner)findViewById(R.h.dDk));
    this.XPQ.setSelection(WXHardCoderJNI.hcSendPicMsgCPU);
    this.XPR = ((Spinner)findViewById(R.h.dJR));
    this.XPR.setSelection(WXHardCoderJNI.hcSendPicMsgIO);
    this.XPS = ((CheckBox)findViewById(R.h.dWN));
    this.XPS.setChecked(WXHardCoderJNI.hcSendPicMsgThr);
    this.XPT = ((CheckBox)findViewById(R.h.dAj));
    this.XPT.setChecked(WXHardCoderJNI.hcReceiveMsgEnable);
    this.XPU = ((EditText)findViewById(R.h.dDU));
    this.XPU.setText(WXHardCoderJNI.hcReceiveMsgDelay);
    this.XPV = ((EditText)findViewById(R.h.dXj));
    this.XPV.setText(WXHardCoderJNI.hcReceiveMsgTimeout);
    this.XPV.setSelection(this.XPV.getText().length());
    this.XPW = ((EditText)findViewById(R.h.dpT));
    this.XPW.setText(WXHardCoderJNI.hcReceiveMsgAction);
    this.XPX = ((Spinner)findViewById(R.h.dDi));
    this.XPX.setSelection(WXHardCoderJNI.hcReceiveMsgCPU);
    this.XPY = ((Spinner)findViewById(R.h.dJP));
    this.XPY.setSelection(WXHardCoderJNI.hcReceiveMsgIO);
    this.XPZ = ((CheckBox)findViewById(R.h.dWL));
    this.XPZ.setChecked(WXHardCoderJNI.hcReceiveMsgThr);
    this.XQa = ((CheckBox)findViewById(R.h.dAq));
    this.XQa.setChecked(WXHardCoderJNI.hcUpdateChatroomEnable);
    this.XQb = ((EditText)findViewById(R.h.dEa));
    this.XQb.setText(WXHardCoderJNI.hcUpdateChatroomDelay);
    this.XQc = ((EditText)findViewById(R.h.dXp));
    this.XQc.setText(WXHardCoderJNI.hcUpdateChatroomTimeout);
    this.XQc.setSelection(this.XQc.getText().length());
    this.XQd = ((EditText)findViewById(R.h.dpZ));
    this.XQd.setText(WXHardCoderJNI.hcUpdateChatroomAction);
    this.XQe = ((Spinner)findViewById(R.h.dDo));
    this.XQe.setSelection(WXHardCoderJNI.hcUpdateChatroomCPU);
    this.XQf = ((Spinner)findViewById(R.h.dJV));
    this.XQf.setSelection(WXHardCoderJNI.hcUpdateChatroomIO);
    this.XQg = ((CheckBox)findViewById(R.h.dWR));
    this.XQg.setChecked(WXHardCoderJNI.hcUpdateChatroomThr);
    this.XQh = ((EditText)findViewById(R.h.dYy));
    this.XQh.setText(WXHardCoderJNI.hcUpdateChatroomMemberCount);
    this.XQi = ((CheckBox)findViewById(R.h.dzZ));
    this.XQi.setChecked(WXHardCoderJNI.hcDBEnable);
    this.XQj = ((EditText)findViewById(R.h.dDM));
    this.XQj.setText(WXHardCoderJNI.hcDBDelayQuery);
    this.XQk = ((EditText)findViewById(R.h.dDN));
    this.XQk.setText(WXHardCoderJNI.hcDBDelayWrite);
    this.XQl = ((EditText)findViewById(R.h.dXb));
    this.XQl.setText(WXHardCoderJNI.hcDBTimeout);
    this.XQm = ((EditText)findViewById(R.h.dXc));
    this.XQm.setText(WXHardCoderJNI.hcDBTimeoutBusy);
    this.XQn = ((EditText)findViewById(R.h.dpL));
    this.XQn.setText(WXHardCoderJNI.hcDBActionQuery);
    this.XQo = ((EditText)findViewById(R.h.dpM));
    this.XQo.setText(WXHardCoderJNI.hcDBActionWrite);
    this.XQp = ((Spinner)findViewById(R.h.dDb));
    this.XQp.setSelection(WXHardCoderJNI.hcDBCPU);
    this.XQq = ((Spinner)findViewById(R.h.dJI));
    this.XQq.setSelection(WXHardCoderJNI.hcDBIO);
    this.XQr = ((CheckBox)findViewById(R.h.dWE));
    this.XQr.setChecked(WXHardCoderJNI.hcDBThr);
    this.XQs = ((CheckBox)findViewById(R.h.dAr));
    this.XQs.setChecked(WXHardCoderJNI.hcEncodeVideoEnable);
    this.XQt = ((EditText)findViewById(R.h.dEb));
    this.XQt.setText(WXHardCoderJNI.hcEncodeVideoDelay);
    this.XQu = ((EditText)findViewById(R.h.dXq));
    this.XQu.setText(WXHardCoderJNI.hcEncodeVideoTimeout);
    this.XQv = ((EditText)findViewById(R.h.dqa));
    this.XQv.setText(WXHardCoderJNI.hcEncodeVideoAction);
    this.XQw = ((Spinner)findViewById(R.h.dDp));
    this.XQw.setSelection(WXHardCoderJNI.hcEncodeVideoCPU);
    this.XQx = ((Spinner)findViewById(R.h.dJW));
    this.XQx.setSelection(WXHardCoderJNI.hcEncodeVideoIO);
    this.XQy = ((CheckBox)findViewById(R.h.dWS));
    this.XQy.setChecked(WXHardCoderJNI.hcEncodeVideoThr);
    this.XQz = ((CheckBox)findViewById(R.h.dAb));
    this.XQz.setChecked(WXHardCoderJNI.hcDecodePicEnable);
    this.XQA = ((EditText)findViewById(R.h.dDO));
    this.XQA.setText(WXHardCoderJNI.hcDecodePicDelay);
    this.XQB = ((EditText)findViewById(R.h.dXd));
    this.XQB.setText(WXHardCoderJNI.hcDecodePicTimeout);
    this.XQC = ((EditText)findViewById(R.h.dpN));
    this.XQC.setText(WXHardCoderJNI.hcDecodePicAction);
    this.XQD = ((Spinner)findViewById(R.h.dDc));
    this.XQD.setSelection(WXHardCoderJNI.hcDecodePicCPU);
    this.XQE = ((Spinner)findViewById(R.h.dJJ));
    this.XQE.setSelection(WXHardCoderJNI.hcDecodePicIO);
    this.XQF = ((CheckBox)findViewById(R.h.dWF));
    this.XQF.setChecked(WXHardCoderJNI.hcDecodePicThr);
    this.XQG = ((CheckBox)findViewById(R.h.dAe));
    this.XQG.setChecked(WXHardCoderJNI.hcGifEnable);
    this.XQH = ((EditText)findViewById(R.h.dDQ));
    this.XQH.setText(WXHardCoderJNI.hcGifDelay);
    this.XQI = ((EditText)findViewById(R.h.dXf));
    this.XQI.setText(WXHardCoderJNI.hcGifTimeout);
    this.XQJ = ((EditText)findViewById(R.h.dpP));
    this.XQJ.setText(WXHardCoderJNI.hcGifAction);
    this.XQK = ((Spinner)findViewById(R.h.dDe));
    this.XQK.setSelection(WXHardCoderJNI.hcGifCPU);
    this.XQL = ((Spinner)findViewById(R.h.dJL));
    this.XQL.setSelection(WXHardCoderJNI.hcGifIO);
    this.XQM = ((CheckBox)findViewById(R.h.dWH));
    this.XQM.setChecked(WXHardCoderJNI.hcGifThr);
    this.XQN = ((CheckBox)findViewById(R.h.dAf));
    this.XQN.setChecked(WXHardCoderJNI.hcGifFrameEnable);
    this.XQO = ((EditText)findViewById(R.h.dDR));
    this.XQO.setText(WXHardCoderJNI.hcGifFrameDelay);
    this.XQP = ((EditText)findViewById(R.h.dXg));
    this.XQP.setText(WXHardCoderJNI.hcGifFrameTimeout);
    this.XQQ = ((EditText)findViewById(R.h.dpQ));
    this.XQQ.setText(WXHardCoderJNI.hcGifFrameAction);
    this.XQR = ((Spinner)findViewById(R.h.dDf));
    this.XQR.setSelection(WXHardCoderJNI.hcGifFrameCPU);
    this.XQS = ((Spinner)findViewById(R.h.dJM));
    this.XQS.setSelection(WXHardCoderJNI.hcGifFrameIO);
    this.XQT = ((CheckBox)findViewById(R.h.dWI));
    this.XQT.setChecked(WXHardCoderJNI.hcGifFrameThr);
    this.XQU = ((CheckBox)findViewById(R.h.dAn));
    this.XQU.setChecked(WXHardCoderJNI.hcSNSScrollEnable);
    this.XQV = ((EditText)findViewById(R.h.dDY));
    this.XQV.setText(WXHardCoderJNI.hcSNSScrollDelay);
    this.XQW = ((EditText)findViewById(R.h.dXn));
    this.XQW.setText(WXHardCoderJNI.hcSNSScrollTimeout);
    this.XQX = ((EditText)findViewById(R.h.dpX));
    this.XQX.setText(WXHardCoderJNI.hcSNSScrollAction);
    this.XQY = ((Spinner)findViewById(R.h.dDm));
    this.XQY.setSelection(WXHardCoderJNI.hcSNSScrollCPU);
    this.XQZ = ((Spinner)findViewById(R.h.dJT));
    this.XQZ.setSelection(WXHardCoderJNI.hcSNSScrollIO);
    this.XRa = ((CheckBox)findViewById(R.h.dWP));
    this.XRa.setChecked(WXHardCoderJNI.hcSNSScrollThr);
    this.XRb = ((CheckBox)findViewById(R.h.dAo));
    this.XRb.setChecked(WXHardCoderJNI.hcSNSUserScrollEnable);
    this.XRc = ((EditText)findViewById(R.h.dDZ));
    this.XRc.setText(WXHardCoderJNI.hcSNSUserScrollDelay);
    this.XRd = ((EditText)findViewById(R.h.dXo));
    this.XRd.setText(WXHardCoderJNI.hcSNSUserScrollTimeout);
    this.XRe = ((EditText)findViewById(R.h.dpY));
    this.XRe.setText(WXHardCoderJNI.hcSNSUserScrollAction);
    this.XRf = ((Spinner)findViewById(R.h.dDn));
    this.XRf.setSelection(WXHardCoderJNI.hcSNSUserScrollCPU);
    this.XRg = ((Spinner)findViewById(R.h.dJU));
    this.XRg.setSelection(WXHardCoderJNI.hcSNSUserScrollIO);
    this.XRh = ((CheckBox)findViewById(R.h.dWQ));
    this.XRh.setChecked(WXHardCoderJNI.hcSNSUserScrollThr);
    this.XRi = ((CheckBox)findViewById(R.h.dAm));
    this.XRi.setChecked(WXHardCoderJNI.hcSNSMsgScrollEnable);
    this.XRj = ((EditText)findViewById(R.h.dDX));
    this.XRj.setText(WXHardCoderJNI.hcSNSMsgScrollDelay);
    this.XRk = ((EditText)findViewById(R.h.dXm));
    this.XRk.setText(WXHardCoderJNI.hcSNSMsgScrollTimeout);
    this.XRl = ((EditText)findViewById(R.h.dpW));
    this.XRl.setText(WXHardCoderJNI.hcSNSMsgScrollAction);
    this.XRm = ((Spinner)findViewById(R.h.dDl));
    this.XRm.setSelection(WXHardCoderJNI.hcSNSMsgScrollCPU);
    this.XRn = ((Spinner)findViewById(R.h.dJS));
    this.XRn.setSelection(WXHardCoderJNI.hcSNSMsgScrollIO);
    this.XRo = ((CheckBox)findViewById(R.h.dWO));
    this.XRo.setChecked(WXHardCoderJNI.hcSNSMsgScrollThr);
    this.XRp = ((CheckBox)findViewById(R.h.dAh));
    this.XRp.setChecked(WXHardCoderJNI.hcMediaGalleryScrollEnable);
    this.XRq = ((EditText)findViewById(R.h.dDS));
    this.XRq.setText(WXHardCoderJNI.hcMediaGalleryScrollDelay);
    this.XRr = ((EditText)findViewById(R.h.dXh));
    this.XRr.setText(WXHardCoderJNI.hcMediaGalleryScrollTimeout);
    this.XRs = ((EditText)findViewById(R.h.dpR));
    this.XRs.setText(WXHardCoderJNI.hcMediaGalleryScrollAction);
    this.XRt = ((Spinner)findViewById(R.h.dDg));
    this.XRt.setSelection(WXHardCoderJNI.hcMediaGalleryScrollCPU);
    this.XRu = ((Spinner)findViewById(R.h.dJN));
    this.XRu.setSelection(WXHardCoderJNI.hcMediaGalleryScrollIO);
    this.XRv = ((CheckBox)findViewById(R.h.dWJ));
    this.XRv.setChecked(WXHardCoderJNI.hcMediaGalleryScrollThr);
    this.XRw = ((CheckBox)findViewById(R.h.dzU));
    this.XRw.setChecked(WXHardCoderJNI.hcAlbumScrollEnable);
    this.XRx = ((EditText)findViewById(R.h.dDJ));
    this.XRx.setText(WXHardCoderJNI.hcAlbumScrollDelay);
    this.XRy = ((EditText)findViewById(R.h.dWY));
    this.XRy.setText(WXHardCoderJNI.hcAlbumScrollTimeout);
    this.XRz = ((EditText)findViewById(R.h.dpI));
    this.XRz.setText(WXHardCoderJNI.hcAlbumScrollAction);
    this.XRA = ((Spinner)findViewById(R.h.dCY));
    this.XRA.setSelection(WXHardCoderJNI.hcAlbumScrollCPU);
    this.XRB = ((Spinner)findViewById(R.h.dJF));
    this.XRB.setSelection(WXHardCoderJNI.hcAlbumScrollIO);
    this.XRC = ((CheckBox)findViewById(R.h.dWB));
    this.XRC.setChecked(WXHardCoderJNI.hcAlbumScrollThr);
    this.XRD = ((CheckBox)findViewById(R.h.dzV));
    this.XRD.setChecked(WXHardCoderJNI.hcBizEnable);
    this.XRE = ((EditText)findViewById(R.h.dDK));
    this.XRE.setText(WXHardCoderJNI.hcBizDelay);
    this.XRF = ((EditText)findViewById(R.h.dWZ));
    this.XRF.setText(WXHardCoderJNI.hcBizTimeout);
    this.XRG = ((EditText)findViewById(R.h.dpJ));
    this.XRG.setText(WXHardCoderJNI.hcBizAction);
    this.XRH = ((Spinner)findViewById(R.h.dCZ));
    this.XRH.setSelection(WXHardCoderJNI.hcBizCPU);
    this.XRI = ((Spinner)findViewById(R.h.dJG));
    this.XRI.setSelection(WXHardCoderJNI.hcBizIO);
    this.XRJ = ((CheckBox)findViewById(R.h.dWC));
    this.XRJ.setChecked(WXHardCoderJNI.hcBizThr);
    this.XPe.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(39062);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/tools/HardCoderSettingUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
    if (this.JgH)
    {
      localTimePickerDialog = new TimePickerDialog(getContext(), this.JgI, WXHardCoderJNI.hcBeginTimeHour, WXHardCoderJNI.hcBeginTimeMin, false);
      AppMethodBeat.o(39066);
      return localTimePickerDialog;
    }
    TimePickerDialog localTimePickerDialog = new TimePickerDialog(getContext(), this.JgI, WXHardCoderJNI.hcEndTimeHour, WXHardCoderJNI.hcBeginTimeMin, false);
    AppMethodBeat.o(39066);
    return localTimePickerDialog;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39067);
    Log.i("HardCoderSettingUI", "save");
    if ((this.XPe.isChecked()) && (!WXHardCoderJNI.getEnable()))
    {
      WXHardCoderJNI.setHcEnable(this.XPe.isChecked());
      WXHardCoderJNI.initHardCoder(com.tencent.mm.plugin.hardcoder.a.eCg(), com.tencent.mm.plugin.hardcoder.a.eCg(), null);
    }
    WXHardCoderJNI.setDebug(this.XPg.isChecked());
    WXHardCoderJNI.setHcEnable(this.XPe.isChecked());
    WXHardCoderJNI.hcRetryInterval = Util.getInt(this.XPf.getText().toString(), WXHardCoderJNI.hcRetryInterval);
    if (WXHardCoderJNI.isCheckEnv())
    {
      WXHardCoderJNI.setDebug(WXHardCoderJNI.getDebug());
      WXHardCoderJNI.setHcEnable(WXHardCoderJNI.getEnable());
      WXHardCoderJNI.setRetryConnectInterval(WXHardCoderJNI.hcRetryInterval);
    }
    WXHardCoderJNI.hcTimeLimit = this.XPi.isChecked();
    WXHardCoderJNI.hcBootEnable = this.XPk.isChecked();
    WXHardCoderJNI.hcBootDelay = Util.getInt(this.XPl.getText().toString(), WXHardCoderJNI.hcBootDelay);
    WXHardCoderJNI.hcBootCPU = this.XPo.getSelectedItemPosition();
    WXHardCoderJNI.hcBootIO = this.XPp.getSelectedItemPosition();
    WXHardCoderJNI.hcBootThr = this.XPq.isChecked();
    WXHardCoderJNI.hcBootTimeout = Util.getInt(this.XPm.getText().toString(), WXHardCoderJNI.hcBootTimeout);
    WXHardCoderJNI.hcBootAction = Util.getLong(this.XPn.getText().toString(), WXHardCoderJNI.hcBootAction);
    WXHardCoderJNI.hcEnterChattingEnable = this.XPr.isChecked();
    WXHardCoderJNI.hcEnterChattingDelay = Util.getInt(this.XPs.getText().toString(), WXHardCoderJNI.hcEnterChattingDelay);
    WXHardCoderJNI.hcEnterChattingCPU = this.XPv.getSelectedItemPosition();
    WXHardCoderJNI.hcEnterChattingIO = this.XPw.getSelectedItemPosition();
    WXHardCoderJNI.hcEnterChattingThr = this.XPx.isChecked();
    WXHardCoderJNI.hcEnterChattingTimeout = Util.getInt(this.XPt.getText().toString(), WXHardCoderJNI.hcEnterChattingTimeout);
    WXHardCoderJNI.hcEnterChattingAction = Util.getLong(this.XPu.getText().toString(), WXHardCoderJNI.hcEnterChattingAction);
    WXHardCoderJNI.hcQuitChattingEnable = this.XPy.isChecked();
    WXHardCoderJNI.hcQuitChattingDelay = Util.getInt(this.XPz.getText().toString(), WXHardCoderJNI.hcQuitChattingDelay);
    WXHardCoderJNI.hcQuitChattingCPU = this.XPC.getSelectedItemPosition();
    WXHardCoderJNI.hcQuitChattingIO = this.XPD.getSelectedItemPosition();
    WXHardCoderJNI.hcQuitChattingThr = this.XPE.isChecked();
    WXHardCoderJNI.hcQuitChattingTimeout = Util.getInt(this.XPA.getText().toString(), WXHardCoderJNI.hcQuitChattingTimeout);
    WXHardCoderJNI.hcQuitChattingAction = Util.getLong(this.XPB.getText().toString(), WXHardCoderJNI.hcQuitChattingAction);
    WXHardCoderJNI.hcSendMsgEnable = this.XPF.isChecked();
    WXHardCoderJNI.hcSendMsgDelay = Util.getInt(this.XPG.getText().toString(), WXHardCoderJNI.hcSendMsgDelay);
    WXHardCoderJNI.hcSendMsgCPU = this.XPJ.getSelectedItemPosition();
    WXHardCoderJNI.hcSendMsgIO = this.XPK.getSelectedItemPosition();
    WXHardCoderJNI.hcSendMsgThr = this.XPL.isChecked();
    WXHardCoderJNI.hcSendMsgTimeout = Util.getInt(this.XPH.getText().toString(), WXHardCoderJNI.hcSendMsgTimeout);
    WXHardCoderJNI.hcSendMsgAction = Util.getLong(this.XPI.getText().toString(), WXHardCoderJNI.hcSendMsgAction);
    WXHardCoderJNI.hcSendPicMsgEnable = this.XPM.isChecked();
    WXHardCoderJNI.hcSendPicMsgDelay = Util.getInt(this.XPN.getText().toString(), WXHardCoderJNI.hcSendPicMsgDelay);
    WXHardCoderJNI.hcSendPicMsgCPU = this.XPQ.getSelectedItemPosition();
    WXHardCoderJNI.hcSendPicMsgIO = this.XPR.getSelectedItemPosition();
    WXHardCoderJNI.hcSendPicMsgThr = this.XPS.isChecked();
    WXHardCoderJNI.hcSendPicMsgTimeout = Util.getInt(this.XPO.getText().toString(), WXHardCoderJNI.hcSendPicMsgTimeout);
    WXHardCoderJNI.hcSendPicMsgAction = Util.getLong(this.XPP.getText().toString(), WXHardCoderJNI.hcSendPicMsgAction);
    WXHardCoderJNI.hcReceiveMsgEnable = this.XPT.isChecked();
    WXHardCoderJNI.hcReceiveMsgDelay = Util.getInt(this.XPU.getText().toString(), WXHardCoderJNI.hcReceiveMsgDelay);
    WXHardCoderJNI.hcReceiveMsgCPU = this.XPX.getSelectedItemPosition();
    WXHardCoderJNI.hcReceiveMsgIO = this.XPY.getSelectedItemPosition();
    WXHardCoderJNI.hcReceiveMsgThr = this.XPZ.isChecked();
    WXHardCoderJNI.hcReceiveMsgTimeout = Util.getInt(this.XPV.getText().toString(), WXHardCoderJNI.hcReceiveMsgTimeout);
    WXHardCoderJNI.hcReceiveMsgAction = Util.getLong(this.XPW.getText().toString(), WXHardCoderJNI.hcReceiveMsgAction);
    WXHardCoderJNI.hcUpdateChatroomEnable = this.XQa.isChecked();
    WXHardCoderJNI.hcUpdateChatroomDelay = Util.getInt(this.XQb.getText().toString(), WXHardCoderJNI.hcUpdateChatroomDelay);
    WXHardCoderJNI.hcUpdateChatroomCPU = this.XQe.getSelectedItemPosition();
    WXHardCoderJNI.hcUpdateChatroomIO = this.XQf.getSelectedItemPosition();
    WXHardCoderJNI.hcUpdateChatroomThr = this.XQg.isChecked();
    WXHardCoderJNI.hcUpdateChatroomTimeout = Util.getInt(this.XQc.getText().toString(), WXHardCoderJNI.hcUpdateChatroomTimeout);
    WXHardCoderJNI.hcUpdateChatroomAction = Util.getLong(this.XQd.getText().toString(), WXHardCoderJNI.hcUpdateChatroomAction);
    WXHardCoderJNI.hcUpdateChatroomMemberCount = Util.getLong(this.XQh.getText().toString(), WXHardCoderJNI.hcUpdateChatroomMemberCount);
    WXHardCoderJNI.hcDBEnable = this.XQi.isChecked();
    WXHardCoderJNI.hcDBDelayQuery = Util.getInt(this.XQj.getText().toString(), WXHardCoderJNI.hcDBDelayQuery);
    WXHardCoderJNI.hcDBDelayWrite = Util.getInt(this.XQk.getText().toString(), WXHardCoderJNI.hcDBDelayWrite);
    WXHardCoderJNI.hcDBCPU = this.XPo.getSelectedItemPosition();
    WXHardCoderJNI.hcDBIO = this.XPp.getSelectedItemPosition();
    WXHardCoderJNI.hcDBThr = this.XPq.isChecked();
    WXHardCoderJNI.hcDBTimeout = Util.getInt(this.XQl.getText().toString(), WXHardCoderJNI.hcDBTimeout);
    WXHardCoderJNI.hcDBTimeoutBusy = Util.getInt(this.XQm.getText().toString(), WXHardCoderJNI.hcDBTimeoutBusy);
    WXHardCoderJNI.hcDBActionQuery = Util.getLong(this.XQn.getText().toString(), WXHardCoderJNI.hcDBActionQuery);
    WXHardCoderJNI.hcDBActionWrite = Util.getLong(this.XQo.getText().toString(), WXHardCoderJNI.hcDBActionWrite);
    WXHardCoderJNI.hcEncodeVideoEnable = this.XQs.isChecked();
    WXHardCoderJNI.hcEncodeVideoDelay = Util.getInt(this.XQt.getText().toString(), WXHardCoderJNI.hcEncodeVideoDelay);
    WXHardCoderJNI.hcEncodeVideoCPU = this.XQw.getSelectedItemPosition();
    WXHardCoderJNI.hcEncodeVideoIO = this.XQx.getSelectedItemPosition();
    WXHardCoderJNI.hcEncodeVideoThr = this.XQy.isChecked();
    WXHardCoderJNI.hcEncodeVideoTimeout = Util.getInt(this.XQu.getText().toString(), WXHardCoderJNI.hcEncodeVideoTimeout);
    WXHardCoderJNI.hcEncodeVideoAction = Util.getLong(this.XQv.getText().toString(), WXHardCoderJNI.hcEncodeVideoAction);
    WXHardCoderJNI.hcDecodePicEnable = this.XQz.isChecked();
    WXHardCoderJNI.hcDecodePicDelay = Util.getInt(this.XQA.getText().toString(), WXHardCoderJNI.hcDecodePicDelay);
    WXHardCoderJNI.hcDecodePicCPU = this.XQD.getSelectedItemPosition();
    WXHardCoderJNI.hcDecodePicIO = this.XQE.getSelectedItemPosition();
    WXHardCoderJNI.hcDecodePicThr = this.XQF.isChecked();
    WXHardCoderJNI.hcDecodePicTimeout = Util.getInt(this.XQB.getText().toString(), WXHardCoderJNI.hcDecodePicTimeout);
    WXHardCoderJNI.hcDecodePicAction = Util.getLong(this.XQC.getText().toString(), WXHardCoderJNI.hcDecodePicAction);
    WXHardCoderJNI.hcGifEnable = this.XQG.isChecked();
    WXHardCoderJNI.hcGifDelay = Util.getInt(this.XQH.getText().toString(), WXHardCoderJNI.hcGifDelay);
    WXHardCoderJNI.hcGifCPU = this.XQK.getSelectedItemPosition();
    WXHardCoderJNI.hcGifIO = this.XQL.getSelectedItemPosition();
    WXHardCoderJNI.hcGifThr = this.XQM.isChecked();
    WXHardCoderJNI.hcGifTimeout = Util.getInt(this.XQI.getText().toString(), WXHardCoderJNI.hcGifTimeout);
    WXHardCoderJNI.hcGifAction = Util.getLong(this.XQJ.getText().toString(), WXHardCoderJNI.hcGifAction);
    WXHardCoderJNI.hcGifFrameEnable = this.XQN.isChecked();
    WXHardCoderJNI.hcGifFrameDelay = Util.getInt(this.XQO.getText().toString(), WXHardCoderJNI.hcGifFrameDelay);
    WXHardCoderJNI.hcGifFrameCPU = this.XQR.getSelectedItemPosition();
    WXHardCoderJNI.hcGifFrameIO = this.XQS.getSelectedItemPosition();
    WXHardCoderJNI.hcGifFrameThr = this.XQT.isChecked();
    WXHardCoderJNI.hcGifFrameTimeout = Util.getInt(this.XQP.getText().toString(), WXHardCoderJNI.hcGifFrameTimeout);
    WXHardCoderJNI.hcGifFrameAction = Util.getLong(this.XQQ.getText().toString(), WXHardCoderJNI.hcGifFrameAction);
    WXHardCoderJNI.hcSNSScrollEnable = this.XQU.isChecked();
    WXHardCoderJNI.hcSNSScrollDelay = Util.getInt(this.XQV.getText().toString(), WXHardCoderJNI.hcSNSScrollDelay);
    WXHardCoderJNI.hcSNSScrollCPU = this.XQY.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSScrollIO = this.XQZ.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSScrollThr = this.XRa.isChecked();
    WXHardCoderJNI.hcSNSScrollTimeout = Util.getInt(this.XQW.getText().toString(), WXHardCoderJNI.hcSNSScrollTimeout);
    WXHardCoderJNI.hcSNSScrollAction = Util.getLong(this.XQX.getText().toString(), WXHardCoderJNI.hcSNSScrollAction);
    WXHardCoderJNI.hcSNSUserScrollEnable = this.XRb.isChecked();
    WXHardCoderJNI.hcSNSUserScrollDelay = Util.getInt(this.XRc.getText().toString(), WXHardCoderJNI.hcSNSUserScrollDelay);
    WXHardCoderJNI.hcSNSUserScrollCPU = this.XRf.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSUserScrollIO = this.XRg.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSUserScrollThr = this.XRh.isChecked();
    WXHardCoderJNI.hcSNSUserScrollTimeout = Util.getInt(this.XRd.getText().toString(), WXHardCoderJNI.hcSNSUserScrollTimeout);
    WXHardCoderJNI.hcSNSUserScrollAction = Util.getLong(this.XRe.getText().toString(), WXHardCoderJNI.hcSNSUserScrollAction);
    WXHardCoderJNI.hcSNSMsgScrollEnable = this.XRi.isChecked();
    WXHardCoderJNI.hcSNSMsgScrollDelay = Util.getInt(this.XRj.getText().toString(), WXHardCoderJNI.hcSNSMsgScrollDelay);
    WXHardCoderJNI.hcSNSMsgScrollCPU = this.XRm.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSMsgScrollIO = this.XRn.getSelectedItemPosition();
    WXHardCoderJNI.hcSNSMsgScrollThr = this.XRo.isChecked();
    WXHardCoderJNI.hcSNSMsgScrollTimeout = Util.getInt(this.XRk.getText().toString(), WXHardCoderJNI.hcSNSMsgScrollTimeout);
    WXHardCoderJNI.hcSNSMsgScrollAction = Util.getLong(this.XRl.getText().toString(), WXHardCoderJNI.hcSNSMsgScrollAction);
    WXHardCoderJNI.hcMediaGalleryScrollEnable = this.XRp.isChecked();
    WXHardCoderJNI.hcMediaGalleryScrollDelay = Util.getInt(this.XRq.getText().toString(), WXHardCoderJNI.hcMediaGalleryScrollDelay);
    WXHardCoderJNI.hcMediaGalleryScrollCPU = this.XRt.getSelectedItemPosition();
    WXHardCoderJNI.hcMediaGalleryScrollIO = this.XRu.getSelectedItemPosition();
    WXHardCoderJNI.hcMediaGalleryScrollThr = this.XRv.isChecked();
    WXHardCoderJNI.hcMediaGalleryScrollTimeout = Util.getInt(this.XRr.getText().toString(), WXHardCoderJNI.hcMediaGalleryScrollTimeout);
    WXHardCoderJNI.hcMediaGalleryScrollAction = Util.getLong(this.XRs.getText().toString(), WXHardCoderJNI.hcMediaGalleryScrollAction);
    WXHardCoderJNI.hcAlbumScrollEnable = this.XRw.isChecked();
    WXHardCoderJNI.hcAlbumScrollDelay = Util.getInt(this.XRx.getText().toString(), WXHardCoderJNI.hcAlbumScrollDelay);
    WXHardCoderJNI.hcAlbumScrollCPU = this.XRA.getSelectedItemPosition();
    WXHardCoderJNI.hcAlbumScrollIO = this.XRB.getSelectedItemPosition();
    WXHardCoderJNI.hcAlbumScrollThr = this.XRC.isChecked();
    WXHardCoderJNI.hcAlbumScrollTimeout = Util.getInt(this.XRy.getText().toString(), WXHardCoderJNI.hcAlbumScrollTimeout);
    WXHardCoderJNI.hcAlbumScrollAction = Util.getLong(this.XRz.getText().toString(), WXHardCoderJNI.hcAlbumScrollAction);
    WXHardCoderJNI.hcBizEnable = this.XRD.isChecked();
    WXHardCoderJNI.hcBizDelay = Util.getInt(this.XRE.getText().toString(), WXHardCoderJNI.hcBizDelay);
    WXHardCoderJNI.hcBizCPU = this.XRH.getSelectedItemPosition();
    WXHardCoderJNI.hcBizIO = this.XRI.getSelectedItemPosition();
    WXHardCoderJNI.hcBizThr = this.XRJ.isChecked();
    WXHardCoderJNI.hcBizTimeout = Util.getInt(this.XRF.getText().toString(), WXHardCoderJNI.hcBizTimeout);
    WXHardCoderJNI.hcBizAction = Util.getLong(this.XRG.getText().toString(), WXHardCoderJNI.hcBizAction);
    c(getContext().getSharedPreferences("hardcoder_setting", 0).edit());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.HardCoderSettingUI
 * JD-Core Version:    0.7.0.1
 */