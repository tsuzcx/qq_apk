package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class djw
  extends cvc
{
  public LinkedList<cwt> BlackList;
  public int BlackListCount;
  public SKBuiltinBuffer_t FzK;
  public LinkedList<cwt> GroupUser;
  public int GroupUserCount;
  public int HyC;
  public SKBuiltinBuffer_t Hyy;
  public String hCW;
  
  public djw()
  {
    AppMethodBeat.i(118468);
    this.BlackList = new LinkedList();
    this.GroupUser = new LinkedList();
    AppMethodBeat.o(118468);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118469);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hyy == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjDesc");
        AppMethodBeat.o(118469);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Hyy != null)
      {
        paramVarArgs.lC(2, this.Hyy.computeSize());
        this.Hyy.writeFields(paramVarArgs);
      }
      if (this.hCW != null) {
        paramVarArgs.d(3, this.hCW);
      }
      if (this.FzK != null)
      {
        paramVarArgs.lC(4, this.FzK.computeSize());
        this.FzK.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.HyC);
      paramVarArgs.aS(6, this.BlackListCount);
      paramVarArgs.e(7, 8, this.BlackList);
      paramVarArgs.aS(8, this.GroupUserCount);
      paramVarArgs.e(9, 8, this.GroupUser);
      AppMethodBeat.o(118469);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1154;
      }
    }
    label1154:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hyy != null) {
        paramInt = i + f.a.a.a.lB(2, this.Hyy.computeSize());
      }
      i = paramInt;
      if (this.hCW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hCW);
      }
      paramInt = i;
      if (this.FzK != null) {
        paramInt = i + f.a.a.a.lB(4, this.FzK.computeSize());
      }
      i = f.a.a.b.b.a.bz(5, this.HyC);
      int j = f.a.a.b.b.a.bz(6, this.BlackListCount);
      int k = f.a.a.a.c(7, 8, this.BlackList);
      int m = f.a.a.b.b.a.bz(8, this.GroupUserCount);
      int n = f.a.a.a.c(9, 8, this.GroupUser);
      AppMethodBeat.o(118469);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.BlackList.clear();
        this.GroupUser.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Hyy == null)
        {
          paramVarArgs = new b("Not all required fields were included: ObjDesc");
          AppMethodBeat.o(118469);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118469);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        djw localdjw = (djw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118469);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjw.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118469);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjw.Hyy = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118469);
          return 0;
        case 3: 
          localdjw.hCW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(118469);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjw.FzK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118469);
          return 0;
        case 5: 
          localdjw.HyC = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(118469);
          return 0;
        case 6: 
          localdjw.BlackListCount = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(118469);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjw.BlackList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118469);
          return 0;
        case 8: 
          localdjw.GroupUserCount = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(118469);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdjw.GroupUser.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118469);
        return 0;
      }
      AppMethodBeat.o(118469);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djw
 * JD-Core Version:    0.7.0.1
 */