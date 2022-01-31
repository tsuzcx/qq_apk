import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.tencent.mobileqq.apollo.game.ApolloFragment;
import com.tencent.mobileqq.apollo.game.ApolloFragmentManager.1;
import com.tencent.mobileqq.apollo.game.ApolloFragmentManager.2;
import com.tencent.mobileqq.apollo.game.ApolloWebViewFragment;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class aikz
{
  public static aikz a;
  public static Stack<ApolloFragment> a;
  public static AtomicInteger a;
  public static Stack<ApolloFragment> b;
  private int jdField_a_of_type_Int;
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  
  static
  {
    jdField_a_of_type_JavaUtilStack = new Stack();
    b = new Stack();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  public static aikz a()
  {
    if (jdField_a_of_type_Aikz == null) {}
    try
    {
      if (jdField_a_of_type_Aikz == null) {
        jdField_a_of_type_Aikz = new aikz();
      }
      return jdField_a_of_type_Aikz;
    }
    finally {}
  }
  
  public static void a(FragmentActivity paramFragmentActivity, Intent paramIntent)
  {
    Object localObject = new Bundle();
    if ((paramIntent != null) && (paramFragmentActivity != null))
    {
      paramIntent.putExtra("vasUsePreWebview", true);
      ((Bundle)localObject).putParcelable("intent", paramIntent);
    }
    try
    {
      ApolloWebViewFragment localApolloWebViewFragment = new ApolloWebViewFragment();
      paramIntent.putExtra("id", jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement());
      localApolloWebViewFragment.setArguments((Bundle)localObject);
      localObject = paramFragmentActivity.getIntent();
      ((Intent)localObject).putExtras(paramIntent);
      localApolloWebViewFragment.b(paramIntent.getExtras());
      localApolloWebViewFragment.c(paramIntent.getExtras());
      paramFragmentActivity.setIntent((Intent)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloFragmentManager", 2, "[notifyViewChange] " + localApolloWebViewFragment.b() + " " + localApolloWebViewFragment.a());
      }
      paramIntent = paramFragmentActivity.getSupportFragmentManager();
      if (!localApolloWebViewFragment.isAdded()) {
        paramIntent.beginTransaction().add(2131301332, localApolloWebViewFragment).commitAllowingStateLoss();
      }
      paramIntent.beginTransaction().show(localApolloWebViewFragment).setCustomAnimations(2130772047, 2130772048).commit();
      if ((!paramFragmentActivity.isFinishing()) && ((paramFragmentActivity instanceof ApolloGameActivity)))
      {
        paramIntent = ((ApolloGameActivity)paramFragmentActivity).a();
        if (paramIntent != null) {
          paramIntent.a = localApolloWebViewFragment;
        }
        paramFragmentActivity.runOnUiThread(new ApolloFragmentManager.1(paramFragmentActivity, localApolloWebViewFragment));
      }
      return;
    }
    catch (Throwable paramFragmentActivity)
    {
      QLog.e("ApolloFragmentManager", 1, paramFragmentActivity, new Object[0]);
    }
  }
  
  private void b(Stack<ApolloFragment> paramStack)
  {
    if ((paramStack != null) && (paramStack.size() > 0) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager != null))
    {
      FragmentTransaction localFragmentTransaction = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction();
      paramStack = paramStack.iterator();
      while (paramStack.hasNext())
      {
        Fragment localFragment = (Fragment)paramStack.next();
        if ((localFragment != null) && (localFragment.isAdded()) && ((this.jdField_a_of_type_AndroidSupportV4AppFragment == null) || (!localFragment.equals(this.jdField_a_of_type_AndroidSupportV4AppFragment)))) {
          localFragmentTransaction.hide(localFragment);
        }
      }
      localFragmentTransaction.commitAllowingStateLoss();
    }
  }
  
  public int a()
  {
    if (jdField_a_of_type_JavaUtilStack == null) {
      return 0;
    }
    return jdField_a_of_type_JavaUtilStack.size();
  }
  
  public void a()
  {
    a(jdField_a_of_type_JavaUtilStack);
    a(b);
    jdField_a_of_type_JavaUtilStack.clear();
    b.clear();
    ailh.a().a();
  }
  
  public void a(Intent paramIntent)
  {
    if (jdField_a_of_type_JavaUtilStack.size() > 1)
    {
      localApolloFragment = (ApolloFragment)jdField_a_of_type_JavaUtilStack.pop();
      if (localApolloFragment != null)
      {
        localApolloFragment.a(null);
        b.push(localApolloFragment);
      }
      localApolloFragment = (ApolloFragment)jdField_a_of_type_JavaUtilStack.peek();
      if (localApolloFragment != null)
      {
        localBundle = new Bundle();
        if (paramIntent != null)
        {
          localBundle.putParcelable("intent", paramIntent);
          localApolloFragment.b(paramIntent.getExtras());
        }
      }
      b();
    }
    while (!QLog.isColorLevel())
    {
      ApolloFragment localApolloFragment;
      Bundle localBundle;
      return;
    }
    QLog.d("ApolloFragmentManager", 2, "[back] reach bottom");
  }
  
  /* Error */
  public void a(Intent paramIntent, java.lang.Class<? extends ApolloFragment> paramClass)
  {
    // Byte code:
    //   0: getstatic 25	aikz:b	Ljava/util/Stack;
    //   3: invokevirtual 264	java/util/Stack:empty	()Z
    //   6: ifeq +34 -> 40
    //   9: aconst_null
    //   10: astore_3
    //   11: aload_3
    //   12: ifnull +41 -> 53
    //   15: getstatic 23	aikz:jdField_a_of_type_JavaUtilStack	Ljava/util/Stack;
    //   18: aload_3
    //   19: invokevirtual 252	java/util/Stack:push	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: pop
    //   23: aload_1
    //   24: ifnull +11 -> 35
    //   27: aload_3
    //   28: aload_1
    //   29: invokevirtual 91	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   32: invokevirtual 256	com/tencent/mobileqq/apollo/game/ApolloFragment:b	(Landroid/os/Bundle;)V
    //   35: aload_0
    //   36: invokevirtual 258	aikz:b	()V
    //   39: return
    //   40: getstatic 25	aikz:b	Ljava/util/Stack;
    //   43: invokevirtual 244	java/util/Stack:pop	()Ljava/lang/Object;
    //   46: checkcast 246	com/tencent/mobileqq/apollo/game/ApolloFragment
    //   49: astore_3
    //   50: goto -39 -> 11
    //   53: ldc 2
    //   55: monitorenter
    //   56: new 46	android/os/Bundle
    //   59: dup
    //   60: invokespecial 47	android/os/Bundle:<init>	()V
    //   63: astore_3
    //   64: aload_1
    //   65: ifnull +90 -> 155
    //   68: aload_1
    //   69: ldc 49
    //   71: iconst_1
    //   72: invokevirtual 55	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   75: pop
    //   76: aload_3
    //   77: ldc 57
    //   79: aload_1
    //   80: invokevirtual 61	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   83: aload_2
    //   84: invokevirtual 269	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   87: checkcast 246	com/tencent/mobileqq/apollo/game/ApolloFragment
    //   90: astore_2
    //   91: aload_1
    //   92: ldc 66
    //   94: getstatic 32	aikz:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   97: invokevirtual 70	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   100: invokevirtual 73	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   103: pop
    //   104: aload_2
    //   105: aload_3
    //   106: invokevirtual 270	com/tencent/mobileqq/apollo/game/ApolloFragment:setArguments	(Landroid/os/Bundle;)V
    //   109: getstatic 23	aikz:jdField_a_of_type_JavaUtilStack	Ljava/util/Stack;
    //   112: aload_2
    //   113: invokevirtual 252	java/util/Stack:push	(Ljava/lang/Object;)Ljava/lang/Object;
    //   116: pop
    //   117: aload_0
    //   118: getfield 41	aikz:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   121: invokevirtual 83	android/support/v4/app/FragmentActivity:getIntent	()Landroid/content/Intent;
    //   124: astore_3
    //   125: aload_3
    //   126: aload_1
    //   127: invokevirtual 87	android/content/Intent:putExtras	(Landroid/content/Intent;)Landroid/content/Intent;
    //   130: pop
    //   131: aload_2
    //   132: aload_1
    //   133: invokevirtual 91	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   136: invokevirtual 256	com/tencent/mobileqq/apollo/game/ApolloFragment:b	(Landroid/os/Bundle;)V
    //   139: aload_2
    //   140: aload_1
    //   141: invokevirtual 91	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   144: invokevirtual 271	com/tencent/mobileqq/apollo/game/ApolloFragment:c	(Landroid/os/Bundle;)V
    //   147: aload_0
    //   148: getfield 41	aikz:jdField_a_of_type_AndroidSupportV4AppFragmentActivity	Landroid/support/v4/app/FragmentActivity;
    //   151: aload_3
    //   152: invokevirtual 100	android/support/v4/app/FragmentActivity:setIntent	(Landroid/content/Intent;)V
    //   155: ldc 2
    //   157: monitorexit
    //   158: goto -123 -> 35
    //   161: astore_1
    //   162: ldc 2
    //   164: monitorexit
    //   165: aload_1
    //   166: athrow
    //   167: astore_1
    //   168: ldc 108
    //   170: iconst_1
    //   171: aload_1
    //   172: iconst_0
    //   173: anewarray 4	java/lang/Object
    //   176: invokestatic 196	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   179: goto -24 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	aikz
    //   0	182	1	paramIntent	Intent
    //   0	182	2	paramClass	java.lang.Class<? extends ApolloFragment>
    //   10	142	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   56	64	161	finally
    //   68	83	161	finally
    //   83	155	161	finally
    //   155	158	161	finally
    //   162	165	161	finally
    //   168	179	161	finally
    //   83	155	167	java/lang/Throwable
  }
  
  public void a(FragmentActivity paramFragmentActivity, int paramInt)
  {
    if (paramFragmentActivity != null)
    {
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager();
      return;
    }
    QLog.e("ApolloFragmentManager", 1, "[init] activity null");
  }
  
  public void a(Stack<ApolloFragment> paramStack)
  {
    if ((paramStack != null) && (paramStack.size() > 0))
    {
      paramStack = paramStack.iterator();
      while (paramStack.hasNext())
      {
        ApolloFragment localApolloFragment = (ApolloFragment)paramStack.next();
        if ((localApolloFragment.isAdded()) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager != null)) {
          this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().remove(localApolloFragment).commit();
        }
      }
    }
  }
  
  public void b()
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentManager != null) && (!jdField_a_of_type_JavaUtilStack.isEmpty()))
      {
        ApolloFragment localApolloFragment = (ApolloFragment)jdField_a_of_type_JavaUtilStack.peek();
        if (localApolloFragment != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloFragmentManager", 2, "[notifyViewChange] " + localApolloFragment.b() + " " + localApolloFragment.a());
          }
          if (!localApolloFragment.isAdded()) {
            this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().add(this.jdField_a_of_type_Int, localApolloFragment).commitAllowingStateLoss();
          }
          this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().show(localApolloFragment).setCustomAnimations(2130772047, 2130772048).commit();
          this.jdField_a_of_type_AndroidSupportV4AppFragment = localApolloFragment;
          b(b);
          b(jdField_a_of_type_JavaUtilStack);
          if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) && ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof ApolloGameActivity))) {
            this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new ApolloFragmentManager.2(this, localApolloFragment));
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloFragmentManager", 1, "[notifyViewChange]", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aikz
 * JD-Core Version:    0.7.0.1
 */