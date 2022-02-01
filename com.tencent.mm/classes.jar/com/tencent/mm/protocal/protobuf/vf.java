package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class vf
  extends cvp
{
  public String FUK;
  public String FUv;
  public String FUw;
  public String FUy;
  public String FvI;
  public int dlw;
  public String dve;
  public String paA;
  public int vls;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72438);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72438);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dlw);
      if (this.paA != null) {
        paramVarArgs.d(3, this.paA);
      }
      if (this.dve != null) {
        paramVarArgs.d(4, this.dve);
      }
      if (this.FUy != null) {
        paramVarArgs.d(5, this.FUy);
      }
      if (this.FvI != null) {
        paramVarArgs.d(6, this.FvI);
      }
      paramVarArgs.aS(7, this.vls);
      if (this.FUK != null) {
        paramVarArgs.d(8, this.FUK);
      }
      if (this.FUw != null) {
        paramVarArgs.d(9, this.FUw);
      }
      if (this.FUv != null) {
        paramVarArgs.d(10, this.FUv);
      }
      AppMethodBeat.o(72438);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label878;
      }
    }
    label878:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dlw);
      paramInt = i;
      if (this.paA != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.paA);
      }
      i = paramInt;
      if (this.dve != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.dve);
      }
      paramInt = i;
      if (this.FUy != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FUy);
      }
      i = paramInt;
      if (this.FvI != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FvI);
      }
      i += f.a.a.b.b.a.bz(7, this.vls);
      paramInt = i;
      if (this.FUK != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FUK);
      }
      i = paramInt;
      if (this.FUw != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FUw);
      }
      paramInt = i;
      if (this.FUv != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FUv);
      }
      AppMethodBeat.o(72438);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72438);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72438);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        vf localvf = (vf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72438);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localvf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72438);
          return 0;
        case 2: 
          localvf.dlw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72438);
          return 0;
        case 3: 
          localvf.paA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 4: 
          localvf.dve = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 5: 
          localvf.FUy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 6: 
          localvf.FvI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 7: 
          localvf.vls = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72438);
          return 0;
        case 8: 
          localvf.FUK = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 9: 
          localvf.FUw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72438);
          return 0;
        }
        localvf.FUv = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72438);
        return 0;
      }
      AppMethodBeat.o(72438);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vf
 * JD-Core Version:    0.7.0.1
 */