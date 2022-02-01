package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class yc
  extends cvp
{
  public String FIi;
  public int FXJ;
  public LinkedList<dni> FXK;
  public int FXL;
  public String Md5;
  public int Version;
  
  public yc()
  {
    AppMethodBeat.i(6405);
    this.FXK = new LinkedList();
    AppMethodBeat.o(6405);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6406);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(6406);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Version);
      if (this.FIi != null) {
        paramVarArgs.d(3, this.FIi);
      }
      if (this.Md5 != null) {
        paramVarArgs.d(4, this.Md5);
      }
      paramVarArgs.aS(5, this.FXJ);
      paramVarArgs.e(6, 8, this.FXK);
      paramVarArgs.aS(7, this.FXL);
      AppMethodBeat.o(6406);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label775;
      }
    }
    label775:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Version);
      paramInt = i;
      if (this.FIi != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FIi);
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Md5);
      }
      paramInt = f.a.a.b.b.a.bz(5, this.FXJ);
      int j = f.a.a.a.c(6, 8, this.FXK);
      int k = f.a.a.b.b.a.bz(7, this.FXL);
      AppMethodBeat.o(6406);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FXK.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(6406);
          throw paramVarArgs;
        }
        AppMethodBeat.o(6406);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        yc localyc = (yc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6406);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6406);
          return 0;
        case 2: 
          localyc.Version = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(6406);
          return 0;
        case 3: 
          localyc.FIi = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(6406);
          return 0;
        case 4: 
          localyc.Md5 = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(6406);
          return 0;
        case 5: 
          localyc.FXJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(6406);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dni();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dni)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyc.FXK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6406);
          return 0;
        }
        localyc.FXL = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(6406);
        return 0;
      }
      AppMethodBeat.o(6406);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yc
 * JD-Core Version:    0.7.0.1
 */