package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bec
  extends cvp
{
  public te GAo;
  public sx GAp;
  public String GAq;
  public td GAr;
  public int GwY;
  public ta GwZ;
  public int Gxc;
  public int Gxd;
  public tp Gxe;
  public int ozR;
  public String ozS;
  public int pjW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114029);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114029);
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
      if (this.GAo != null)
      {
        paramVarArgs.lC(7, this.GAo.computeSize());
        this.GAo.writeFields(paramVarArgs);
      }
      if (this.GAp != null)
      {
        paramVarArgs.lC(8, this.GAp.computeSize());
        this.GAp.writeFields(paramVarArgs);
      }
      if (this.GAq != null) {
        paramVarArgs.d(10, this.GAq);
      }
      paramVarArgs.aS(11, this.Gxc);
      paramVarArgs.aS(12, this.Gxd);
      if (this.Gxe != null)
      {
        paramVarArgs.lC(13, this.Gxe.computeSize());
        this.Gxe.writeFields(paramVarArgs);
      }
      if (this.GAr != null)
      {
        paramVarArgs.lC(14, this.GAr.computeSize());
        this.GAr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114029);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1486;
      }
    }
    label1486:
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
      if (this.GAo != null) {
        i = paramInt + f.a.a.a.lB(7, this.GAo.computeSize());
      }
      paramInt = i;
      if (this.GAp != null) {
        paramInt = i + f.a.a.a.lB(8, this.GAp.computeSize());
      }
      i = paramInt;
      if (this.GAq != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.GAq);
      }
      i = i + f.a.a.b.b.a.bz(11, this.Gxc) + f.a.a.b.b.a.bz(12, this.Gxd);
      paramInt = i;
      if (this.Gxe != null) {
        paramInt = i + f.a.a.a.lB(13, this.Gxe.computeSize());
      }
      i = paramInt;
      if (this.GAr != null) {
        i = paramInt + f.a.a.a.lB(14, this.GAr.computeSize());
      }
      AppMethodBeat.o(114029);
      return i;
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
          AppMethodBeat.o(114029);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114029);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bec localbec = (bec)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 9: 
        default: 
          AppMethodBeat.o(114029);
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
            localbec.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        case 2: 
          localbec.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(114029);
          return 0;
        case 3: 
          localbec.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114029);
          return 0;
        case 4: 
          localbec.pjW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(114029);
          return 0;
        case 5: 
          localbec.GwY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(114029);
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
            localbec.GwZ = ((ta)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new te();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((te)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbec.GAo = ((te)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbec.GAp = ((sx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        case 10: 
          localbec.GAq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114029);
          return 0;
        case 11: 
          localbec.Gxc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(114029);
          return 0;
        case 12: 
          localbec.Gxd = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(114029);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbec.Gxe = ((tp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new td();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((td)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbec.GAr = ((td)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114029);
        return 0;
      }
      AppMethodBeat.o(114029);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bec
 * JD-Core Version:    0.7.0.1
 */