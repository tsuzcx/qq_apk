import com.tencent.qphone.base.util.QLog;

class aibu
  implements anwu
{
  aibu(aibs paramaibs) {}
  
  public boolean a(anwz paramanwz)
  {
    if (QLog.isDevelopLevel()) {
      axql.a(this.a.tag, "onShowHotchatNote", new Object[] { paramanwz });
    }
    if (paramanwz == null)
    {
      if ((this.a.a.b) && (aibs.a(this.a) != null)) {
        aibs.b(this.a).a(this.a.app, this.a.mContext, null, null);
      }
      return false;
    }
    if (aibs.c(this.a) == null) {
      aibs.a(this.a, new bfxw(this.a.app, this.a.mActivity, this.a.sessionInfo, aibs.a(this.a), aibs.a(this.a), this.a.mTroopTips, aibs.a(this.a), null));
    }
    aibs.d(this.a).a(this.a.app, this.a.mContext, paramanwz.a, paramanwz.b);
    this.a.a.b = true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aibu
 * JD-Core Version:    0.7.0.1
 */