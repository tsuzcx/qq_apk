import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashView;
import com.tencent.mobileqq.armap.wealthgod.WealthGodInfo;

class abbg
  implements Runnable
{
  abbg(abbf paramabbf) {}
  
  public void run()
  {
    int i = 0;
    int j = 0;
    if (ARMapActivity.a(this.a.a) != null)
    {
      ARMapActivity.k(this.a.a, true);
      ARMapActivity.a(this.a.a).setLoadStatus(0);
      if (ARMapActivity.a(this.a.a) != null) {
        ARMapActivity.a(this.a.a).b = System.currentTimeMillis();
      }
      ARMapActivity.o(this.a.a);
      if (ARMapActivity.c(this.a.a) == 3)
      {
        ARMapActivity.a(this.a.a).b();
        ARMapActivity.p(this.a.a);
        if (j == 0) {
          break label302;
        }
        this.a.a.n();
      }
    }
    else
    {
      return;
    }
    if ((ARMapActivity.c(this.a.a) == 1) || (ARMapActivity.c(this.a.a) == 7) || ((ARMapActivity.c(this.a.a) == 4) && (ARMapActivity.a(this.a.a).a == 1))) {
      i = 1;
    }
    for (;;)
    {
      j = i;
      if (!this.a.a.f) {
        break;
      }
      ARMapActivity.p(this.a.a);
      j = i;
      break;
      if ((ARMapActivity.c(this.a.a) == 2) || ((ARMapActivity.c(this.a.a) == 4) && (ARMapActivity.a(this.a.a).a == 0))) {
        ARMapActivity.a(this.a.a).b();
      } else {
        ARMapActivity.a(this.a.a).a();
      }
    }
    label302:
    ARMapActivity.a(this.a.a).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abbg
 * JD-Core Version:    0.7.0.1
 */