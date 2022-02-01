package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dcj
  extends cpx
{
  public String FLT;
  public String FLU;
  public String FLV;
  public int FLW;
  public int FLX;
  public int FLY;
  public int FLZ;
  public dch FMa;
  public dch FMb;
  public com.tencent.mm.bw.b Fgp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133198);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fgp == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: ctx");
        AppMethodBeat.o(133198);
        throw paramVarArgs;
      }
      if (this.FLT == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: network_type");
        AppMethodBeat.o(133198);
        throw paramVarArgs;
      }
      if (this.FLU == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: network_info");
        AppMethodBeat.o(133198);
        throw paramVarArgs;
      }
      if (this.FLV == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: device_info");
        AppMethodBeat.o(133198);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Fgp != null) {
        paramVarArgs.c(2, this.Fgp);
      }
      if (this.FLT != null) {
        paramVarArgs.d(3, this.FLT);
      }
      if (this.FLU != null) {
        paramVarArgs.d(4, this.FLU);
      }
      if (this.FLV != null) {
        paramVarArgs.d(5, this.FLV);
      }
      paramVarArgs.aR(6, this.FLW);
      paramVarArgs.aR(7, this.FLX);
      paramVarArgs.aR(8, this.FLY);
      paramVarArgs.aR(9, this.FLZ);
      if (this.FMa != null)
      {
        paramVarArgs.ln(10, this.FMa.computeSize());
        this.FMa.writeFields(paramVarArgs);
      }
      if (this.FMb != null)
      {
        paramVarArgs.ln(11, this.FMb.computeSize());
        this.FMb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133198);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1234;
      }
    }
    label1234:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Fgp != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.Fgp);
      }
      i = paramInt;
      if (this.FLT != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FLT);
      }
      paramInt = i;
      if (this.FLU != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FLU);
      }
      i = paramInt;
      if (this.FLV != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FLV);
      }
      i = i + f.a.a.b.b.a.bx(6, this.FLW) + f.a.a.b.b.a.bx(7, this.FLX) + f.a.a.b.b.a.bx(8, this.FLY) + f.a.a.b.b.a.bx(9, this.FLZ);
      paramInt = i;
      if (this.FMa != null) {
        paramInt = i + f.a.a.a.lm(10, this.FMa.computeSize());
      }
      i = paramInt;
      if (this.FMb != null) {
        i = paramInt + f.a.a.a.lm(11, this.FMb.computeSize());
      }
      AppMethodBeat.o(133198);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Fgp == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: ctx");
          AppMethodBeat.o(133198);
          throw paramVarArgs;
        }
        if (this.FLT == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: network_type");
          AppMethodBeat.o(133198);
          throw paramVarArgs;
        }
        if (this.FLU == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: network_info");
          AppMethodBeat.o(133198);
          throw paramVarArgs;
        }
        if (this.FLV == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: device_info");
          AppMethodBeat.o(133198);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133198);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dcj localdcj = (dcj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133198);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdcj.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133198);
          return 0;
        case 2: 
          localdcj.Fgp = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(133198);
          return 0;
        case 3: 
          localdcj.FLT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133198);
          return 0;
        case 4: 
          localdcj.FLU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133198);
          return 0;
        case 5: 
          localdcj.FLV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133198);
          return 0;
        case 6: 
          localdcj.FLW = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133198);
          return 0;
        case 7: 
          localdcj.FLX = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133198);
          return 0;
        case 8: 
          localdcj.FLY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133198);
          return 0;
        case 9: 
          localdcj.FLZ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133198);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dch();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dch)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdcj.FMa = ((dch)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133198);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dch();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dch)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdcj.FMb = ((dch)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133198);
        return 0;
      }
      AppMethodBeat.o(133198);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcj
 * JD-Core Version:    0.7.0.1
 */