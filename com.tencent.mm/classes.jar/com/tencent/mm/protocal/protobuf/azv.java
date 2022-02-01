package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class azv
  extends cvp
{
  public int GwY;
  public ta GwZ;
  public tg Gxa;
  public String Gxb;
  public int Gxc;
  public int Gxd;
  public tp Gxe;
  public int ozR;
  public String ozS;
  public int pjW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215416);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(215416);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ozR);
      if (this.ozS != null) {
        paramVarArgs.d(3, this.ozS);
      }
      paramVarArgs.aS(4, this.pjW);
      paramVarArgs.aS(5, this.GwY);
      if (this.GwZ != null)
      {
        paramVarArgs.lC(6, this.GwZ.computeSize());
        this.GwZ.writeFields(paramVarArgs);
      }
      if (this.Gxa != null)
      {
        paramVarArgs.lC(7, this.Gxa.computeSize());
        this.Gxa.writeFields(paramVarArgs);
      }
      if (this.Gxb != null) {
        paramVarArgs.d(8, this.Gxb);
      }
      paramVarArgs.aS(9, this.Gxc);
      paramVarArgs.aS(10, this.Gxd);
      if (this.Gxe != null)
      {
        paramVarArgs.lC(11, this.Gxe.computeSize());
        this.Gxe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(215416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1170;
      }
    }
    label1170:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.pjW) + f.a.a.b.b.a.bz(5, this.GwY);
      paramInt = i;
      if (this.GwZ != null) {
        paramInt = i + f.a.a.a.lB(6, this.GwZ.computeSize());
      }
      i = paramInt;
      if (this.Gxa != null) {
        i = paramInt + f.a.a.a.lB(7, this.Gxa.computeSize());
      }
      paramInt = i;
      if (this.Gxb != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Gxb);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.Gxc) + f.a.a.b.b.a.bz(10, this.Gxd);
      paramInt = i;
      if (this.Gxe != null) {
        paramInt = i + f.a.a.a.lB(11, this.Gxe.computeSize());
      }
      AppMethodBeat.o(215416);
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
          AppMethodBeat.o(215416);
          throw paramVarArgs;
        }
        AppMethodBeat.o(215416);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        azv localazv = (azv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(215416);
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
            localazv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215416);
          return 0;
        case 2: 
          localazv.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215416);
          return 0;
        case 3: 
          localazv.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215416);
          return 0;
        case 4: 
          localazv.pjW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215416);
          return 0;
        case 5: 
          localazv.GwY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215416);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ta();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ta)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazv.GwZ = ((ta)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215416);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazv.Gxa = ((tg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215416);
          return 0;
        case 8: 
          localazv.Gxb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215416);
          return 0;
        case 9: 
          localazv.Gxc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215416);
          return 0;
        case 10: 
          localazv.Gxd = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215416);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new tp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((tp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localazv.Gxe = ((tp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(215416);
        return 0;
      }
      AppMethodBeat.o(215416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azv
 * JD-Core Version:    0.7.0.1
 */