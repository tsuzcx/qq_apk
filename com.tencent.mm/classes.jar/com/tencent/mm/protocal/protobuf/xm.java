package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xm
  extends cvc
{
  public String FWX;
  public String FWY;
  public String FWZ;
  public String FXa;
  public String FXb;
  public String FXc;
  public int Scene;
  public String Title;
  public String ihg;
  public String iht;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(63271);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ihg != null) {
        paramVarArgs.d(2, this.ihg);
      }
      if (this.Title != null) {
        paramVarArgs.d(3, this.Title);
      }
      if (this.FWX != null) {
        paramVarArgs.d(4, this.FWX);
      }
      if (this.FWY != null) {
        paramVarArgs.d(5, this.FWY);
      }
      if (this.FWZ != null) {
        paramVarArgs.d(6, this.FWZ);
      }
      if (this.FXa != null) {
        paramVarArgs.d(7, this.FXa);
      }
      if (this.FXb != null) {
        paramVarArgs.d(8, this.FXb);
      }
      if (this.iht != null) {
        paramVarArgs.d(9, this.iht);
      }
      paramVarArgs.aS(10, this.Scene);
      if (this.FXc != null) {
        paramVarArgs.d(11, this.FXc);
      }
      AppMethodBeat.o(63271);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label906;
      }
    }
    label906:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ihg != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ihg);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Title);
      }
      paramInt = i;
      if (this.FWX != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FWX);
      }
      i = paramInt;
      if (this.FWY != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FWY);
      }
      paramInt = i;
      if (this.FWZ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FWZ);
      }
      i = paramInt;
      if (this.FXa != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FXa);
      }
      paramInt = i;
      if (this.FXb != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FXb);
      }
      i = paramInt;
      if (this.iht != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.iht);
      }
      i += f.a.a.b.b.a.bz(10, this.Scene);
      paramInt = i;
      if (this.FXc != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FXc);
      }
      AppMethodBeat.o(63271);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(63271);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        xm localxm = (xm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(63271);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localxm.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(63271);
          return 0;
        case 2: 
          localxm.ihg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 3: 
          localxm.Title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 4: 
          localxm.FWX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 5: 
          localxm.FWY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 6: 
          localxm.FWZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 7: 
          localxm.FXa = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 8: 
          localxm.FXb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 9: 
          localxm.iht = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 10: 
          localxm.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(63271);
          return 0;
        }
        localxm.FXc = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(63271);
        return 0;
      }
      AppMethodBeat.o(63271);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xm
 * JD-Core Version:    0.7.0.1
 */