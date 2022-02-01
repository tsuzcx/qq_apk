package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ui
  extends cvp
{
  public String FTD;
  public String FTE;
  public String FTF;
  public String FTG;
  public String dAD;
  public int dlw;
  public String paA;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209397);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(209397);
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
      if (this.title != null) {
        paramVarArgs.d(4, this.title);
      }
      if (this.dAD != null) {
        paramVarArgs.d(5, this.dAD);
      }
      if (this.FTD != null) {
        paramVarArgs.d(6, this.FTD);
      }
      if (this.FTE != null) {
        paramVarArgs.d(7, this.FTE);
      }
      if (this.FTF != null) {
        paramVarArgs.d(8, this.FTF);
      }
      if (this.FTG != null) {
        paramVarArgs.d(9, this.FTG);
      }
      AppMethodBeat.o(209397);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label830;
      }
    }
    label830:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dlw);
      paramInt = i;
      if (this.paA != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.paA);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.title);
      }
      paramInt = i;
      if (this.dAD != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.dAD);
      }
      i = paramInt;
      if (this.FTD != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FTD);
      }
      paramInt = i;
      if (this.FTE != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FTE);
      }
      i = paramInt;
      if (this.FTF != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.FTF);
      }
      paramInt = i;
      if (this.FTG != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FTG);
      }
      AppMethodBeat.o(209397);
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
          AppMethodBeat.o(209397);
          throw paramVarArgs;
        }
        AppMethodBeat.o(209397);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ui localui = (ui)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209397);
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
            localui.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209397);
          return 0;
        case 2: 
          localui.dlw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(209397);
          return 0;
        case 3: 
          localui.paA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209397);
          return 0;
        case 4: 
          localui.title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209397);
          return 0;
        case 5: 
          localui.dAD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209397);
          return 0;
        case 6: 
          localui.FTD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209397);
          return 0;
        case 7: 
          localui.FTE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209397);
          return 0;
        case 8: 
          localui.FTF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209397);
          return 0;
        }
        localui.FTG = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(209397);
        return 0;
      }
      AppMethodBeat.o(209397);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ui
 * JD-Core Version:    0.7.0.1
 */