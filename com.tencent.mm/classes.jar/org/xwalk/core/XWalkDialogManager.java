package org.xwalk.core;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import java.util.ArrayList;

public class XWalkDialogManager
{
  public static final int DIALOG_ARCHITECTURE_MISMATCH = 4;
  public static final int DIALOG_DECOMPRESSING = 11;
  public static final int DIALOG_DOWNLOADING = 12;
  public static final int DIALOG_DOWNLOAD_ERROR = 6;
  public static final int DIALOG_NEWER_VERSION = 3;
  public static final int DIALOG_NOT_FOUND = 1;
  public static final int DIALOG_OLDER_VERSION = 2;
  public static final int DIALOG_SELECT_STORE = 7;
  public static final int DIALOG_SIGNATURE_CHECK_ERROR = 5;
  public static final int DIALOG_UNSUPPORTED_STORE = 8;
  private static final String TAG = "XWalkLib";
  private Dialog mActiveDialog;
  private AlertDialog mArchitectureMismatchDialog;
  private Context mContext;
  private ProgressDialog mDecompressingDialog;
  private AlertDialog mDownloadErrorDialog;
  private ProgressDialog mDownloadingDialog;
  private AlertDialog mNewerVersionDialog;
  private AlertDialog mNotFoundDialog;
  private AlertDialog mOlderVersionDialog;
  private AlertDialog mSelectStoreDialog;
  private AlertDialog mSignatureCheckErrorDialog;
  private AlertDialog mUnsupportedStoreDialog;
  
  public XWalkDialogManager(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private AlertDialog buildAlertDialog()
  {
    AlertDialog localAlertDialog = new AlertDialog.Builder(this.mContext).create();
    localAlertDialog.setIcon(17301543);
    localAlertDialog.setCancelable(false);
    localAlertDialog.setCanceledOnTouchOutside(false);
    return localAlertDialog;
  }
  
  private ProgressDialog buildProgressDialog()
  {
    ProgressDialog localProgressDialog = new ProgressDialog(this.mContext);
    localProgressDialog.setIndeterminate(true);
    localProgressDialog.setCancelable(false);
    localProgressDialog.setCanceledOnTouchOutside(false);
    return localProgressDialog;
  }
  
  private void setMessage(AlertDialog paramAlertDialog, int paramInt)
  {
    setMessage(paramAlertDialog, this.mContext.getString(paramInt));
  }
  
  private void setMessage(AlertDialog paramAlertDialog, String paramString)
  {
    String str = paramString.replaceAll("APP_NAME", XWalkEnvironment.getApplicationName());
    paramString = str;
    if (str.startsWith("this")) {
      paramString = str.replaceFirst("this", "This");
    }
    paramAlertDialog.setMessage(paramString);
  }
  
  private void setNegativeButton(AlertDialog paramAlertDialog, int paramInt)
  {
    paramAlertDialog.setButton(-2, this.mContext.getString(paramInt), null);
  }
  
  private void setPositiveButton(AlertDialog paramAlertDialog, int paramInt)
  {
    paramAlertDialog.setButton(-1, this.mContext.getString(paramInt), null);
  }
  
  private void setTitle(AlertDialog paramAlertDialog, int paramInt)
  {
    paramAlertDialog.setTitle(this.mContext.getString(paramInt));
  }
  
  private void showDialog(AlertDialog paramAlertDialog, ArrayList<XWalkDialogManager.ButtonAction> paramArrayList)
  {
    paramAlertDialog.setOnShowListener(new XWalkDialogManager.1(this, paramArrayList, paramAlertDialog));
    this.mActiveDialog = paramAlertDialog;
    this.mActiveDialog.show();
  }
  
  void dismissDialog()
  {
    this.mActiveDialog.dismiss();
    this.mActiveDialog = null;
  }
  
  public AlertDialog getAlertDialog(int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.mNotFoundDialog == null)
      {
        this.mNotFoundDialog = buildAlertDialog();
        setTitle(this.mNotFoundDialog, R.string.startup_not_found_title);
        setMessage(this.mNotFoundDialog, R.string.startup_not_found_message);
        setPositiveButton(this.mNotFoundDialog, R.string.xwalk_get_crosswalk);
        setNegativeButton(this.mNotFoundDialog, R.string.xwalk_close);
      }
      return this.mNotFoundDialog;
    }
    if (paramInt == 2)
    {
      if (this.mOlderVersionDialog == null)
      {
        this.mOlderVersionDialog = buildAlertDialog();
        setTitle(this.mOlderVersionDialog, R.string.startup_older_version_title);
        setMessage(this.mOlderVersionDialog, R.string.startup_older_version_message);
        setPositiveButton(this.mOlderVersionDialog, R.string.xwalk_get_crosswalk);
        setNegativeButton(this.mOlderVersionDialog, R.string.xwalk_close);
      }
      return this.mOlderVersionDialog;
    }
    if (paramInt == 3)
    {
      if (this.mNewerVersionDialog == null)
      {
        this.mNewerVersionDialog = buildAlertDialog();
        setTitle(this.mNewerVersionDialog, R.string.startup_newer_version_title);
        setMessage(this.mNewerVersionDialog, R.string.startup_newer_version_message);
        setNegativeButton(this.mNewerVersionDialog, R.string.xwalk_close);
      }
      return this.mNewerVersionDialog;
    }
    if (paramInt == 4)
    {
      if (this.mArchitectureMismatchDialog == null)
      {
        this.mArchitectureMismatchDialog = buildAlertDialog();
        setTitle(this.mArchitectureMismatchDialog, R.string.startup_architecture_mismatch_title);
        setMessage(this.mArchitectureMismatchDialog, R.string.startup_architecture_mismatch_message);
        setPositiveButton(this.mArchitectureMismatchDialog, R.string.xwalk_get_crosswalk);
        setNegativeButton(this.mArchitectureMismatchDialog, R.string.xwalk_close);
      }
      return this.mArchitectureMismatchDialog;
    }
    if (paramInt == 5)
    {
      if (this.mSignatureCheckErrorDialog == null)
      {
        this.mSignatureCheckErrorDialog = buildAlertDialog();
        setTitle(this.mSignatureCheckErrorDialog, R.string.startup_signature_check_error_title);
        setMessage(this.mSignatureCheckErrorDialog, R.string.startup_signature_check_error_message);
        setNegativeButton(this.mSignatureCheckErrorDialog, R.string.xwalk_close);
      }
      return this.mSignatureCheckErrorDialog;
    }
    if (paramInt == 6)
    {
      if (this.mDownloadErrorDialog == null)
      {
        this.mDownloadErrorDialog = buildAlertDialog();
        setTitle(this.mDownloadErrorDialog, R.string.crosswalk_install_title);
        setMessage(this.mDownloadErrorDialog, R.string.download_failed_message);
        setPositiveButton(this.mDownloadErrorDialog, R.string.xwalk_retry);
        setNegativeButton(this.mDownloadErrorDialog, R.string.xwalk_cancel);
      }
      return this.mDownloadErrorDialog;
    }
    if (paramInt == 7)
    {
      if (this.mSelectStoreDialog == null)
      {
        this.mSelectStoreDialog = buildAlertDialog();
        setTitle(this.mSelectStoreDialog, R.string.crosswalk_install_title);
        setPositiveButton(this.mSelectStoreDialog, R.string.xwalk_continue);
      }
      return this.mSelectStoreDialog;
    }
    if (paramInt == 8)
    {
      if (this.mUnsupportedStoreDialog == null)
      {
        this.mUnsupportedStoreDialog = buildAlertDialog();
        setTitle(this.mUnsupportedStoreDialog, R.string.crosswalk_install_title);
        setMessage(this.mUnsupportedStoreDialog, R.string.unsupported_store_message);
        setNegativeButton(this.mUnsupportedStoreDialog, R.string.xwalk_close);
      }
      return this.mUnsupportedStoreDialog;
    }
    throw new IllegalArgumentException("Invalid dialog id " + paramInt);
  }
  
  public ProgressDialog getProgressDialog(int paramInt)
  {
    if (paramInt == 11)
    {
      if (this.mDecompressingDialog == null)
      {
        this.mDecompressingDialog = buildProgressDialog();
        setTitle(this.mDecompressingDialog, R.string.crosswalk_install_title);
        setMessage(this.mDecompressingDialog, R.string.decompression_progress_message);
        setNegativeButton(this.mDecompressingDialog, R.string.xwalk_cancel);
        this.mDecompressingDialog.setProgressStyle(0);
      }
      return this.mDecompressingDialog;
    }
    if (paramInt == 12)
    {
      if (this.mDownloadingDialog == null)
      {
        this.mDownloadingDialog = buildProgressDialog();
        setTitle(this.mDownloadingDialog, R.string.crosswalk_install_title);
        setMessage(this.mDownloadingDialog, R.string.download_progress_message);
        setNegativeButton(this.mDownloadingDialog, R.string.xwalk_cancel);
        this.mDownloadingDialog.setProgressStyle(1);
      }
      return this.mDownloadingDialog;
    }
    throw new IllegalArgumentException("Invalid dialog id " + paramInt);
  }
  
  boolean isShowingDialog()
  {
    return (this.mActiveDialog != null) && (this.mActiveDialog.isShowing());
  }
  
  public void setAlertDialog(int paramInt, AlertDialog paramAlertDialog)
  {
    if (((paramAlertDialog instanceof ProgressDialog)) || ((paramAlertDialog instanceof DatePickerDialog)) || ((paramAlertDialog instanceof TimePickerDialog))) {
      throw new IllegalArgumentException("The type of dialog must be AlertDialog");
    }
    if (paramInt == 1)
    {
      this.mNotFoundDialog = paramAlertDialog;
      return;
    }
    if (paramInt == 2)
    {
      this.mOlderVersionDialog = paramAlertDialog;
      return;
    }
    if (paramInt == 3)
    {
      this.mNewerVersionDialog = paramAlertDialog;
      return;
    }
    if (paramInt == 4)
    {
      this.mArchitectureMismatchDialog = paramAlertDialog;
      return;
    }
    if (paramInt == 5)
    {
      this.mSignatureCheckErrorDialog = paramAlertDialog;
      return;
    }
    if (paramInt == 6)
    {
      this.mDownloadErrorDialog = paramAlertDialog;
      return;
    }
    if (paramInt == 7)
    {
      this.mSelectStoreDialog = paramAlertDialog;
      return;
    }
    if (paramInt == 8)
    {
      this.mUnsupportedStoreDialog = paramAlertDialog;
      return;
    }
    throw new IllegalArgumentException("Invalid dialog id " + paramInt);
  }
  
  void setProgress(int paramInt1, int paramInt2)
  {
    ProgressDialog localProgressDialog = (ProgressDialog)this.mActiveDialog;
    localProgressDialog.setIndeterminate(false);
    localProgressDialog.setMax(paramInt2);
    localProgressDialog.setProgress(paramInt1);
  }
  
  public void setProgressDialog(int paramInt, ProgressDialog paramProgressDialog)
  {
    if (paramInt == 11)
    {
      this.mDecompressingDialog = paramProgressDialog;
      return;
    }
    if (paramInt == 12)
    {
      this.mDownloadingDialog = paramProgressDialog;
      return;
    }
    throw new IllegalArgumentException("Invalid dialog id " + paramInt);
  }
  
  void showDecompressProgress(Runnable paramRunnable)
  {
    ProgressDialog localProgressDialog = getProgressDialog(11);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new XWalkDialogManager.ButtonAction(-2, paramRunnable, false));
    showDialog(localProgressDialog, localArrayList);
  }
  
  void showDownloadError(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    AlertDialog localAlertDialog = getAlertDialog(6);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new XWalkDialogManager.ButtonAction(-1, paramRunnable2, true));
    localArrayList.add(new XWalkDialogManager.ButtonAction(-2, paramRunnable1, false));
    showDialog(localAlertDialog, localArrayList);
  }
  
  void showDownloadProgress(Runnable paramRunnable)
  {
    ProgressDialog localProgressDialog = getProgressDialog(12);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new XWalkDialogManager.ButtonAction(-2, paramRunnable, false));
    showDialog(localProgressDialog, localArrayList);
  }
  
  void showInitializationError(int paramInt, Runnable paramRunnable1, Runnable paramRunnable2)
  {
    ArrayList localArrayList = new ArrayList();
    AlertDialog localAlertDialog;
    if (paramInt == 2)
    {
      localAlertDialog = getAlertDialog(1);
      localArrayList.add(new XWalkDialogManager.ButtonAction(-1, paramRunnable2, true));
      localArrayList.add(new XWalkDialogManager.ButtonAction(-2, paramRunnable1, false));
      paramRunnable1 = localAlertDialog;
    }
    for (;;)
    {
      showDialog(paramRunnable1, localArrayList);
      return;
      if (paramInt == 3)
      {
        localAlertDialog = getAlertDialog(2);
        localArrayList.add(new XWalkDialogManager.ButtonAction(-1, paramRunnable2, true));
        localArrayList.add(new XWalkDialogManager.ButtonAction(-2, paramRunnable1, false));
        paramRunnable1 = localAlertDialog;
      }
      else if (paramInt == 4)
      {
        paramRunnable2 = getAlertDialog(3);
        localArrayList.add(new XWalkDialogManager.ButtonAction(-2, paramRunnable1, true));
        paramRunnable1 = paramRunnable2;
      }
      else if (paramInt == 6)
      {
        localAlertDialog = getAlertDialog(4);
        localArrayList.add(new XWalkDialogManager.ButtonAction(-1, paramRunnable2, true));
        localArrayList.add(new XWalkDialogManager.ButtonAction(-2, paramRunnable1, false));
        paramRunnable1 = localAlertDialog;
      }
      else
      {
        if (paramInt != 7) {
          break;
        }
        paramRunnable2 = getAlertDialog(5);
        localArrayList.add(new XWalkDialogManager.ButtonAction(-2, paramRunnable1, true));
        paramRunnable1 = paramRunnable2;
      }
    }
    throw new IllegalArgumentException("Invalid status " + paramInt);
  }
  
  void showSelectStore(Runnable paramRunnable, String paramString)
  {
    AlertDialog localAlertDialog = getAlertDialog(7);
    setMessage(localAlertDialog, this.mContext.getString(R.string.select_store_message).replace("STORE_NAME", paramString));
    paramString = new ArrayList();
    paramString.add(new XWalkDialogManager.ButtonAction(-1, paramRunnable, true));
    showDialog(localAlertDialog, paramString);
  }
  
  void showUnsupportedStore(Runnable paramRunnable)
  {
    AlertDialog localAlertDialog = getAlertDialog(8);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new XWalkDialogManager.ButtonAction(-2, paramRunnable, true));
    showDialog(localAlertDialog, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     org.xwalk.core.XWalkDialogManager
 * JD-Core Version:    0.7.0.1
 */