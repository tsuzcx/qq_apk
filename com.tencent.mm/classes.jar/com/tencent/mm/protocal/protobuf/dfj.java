package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dfj
  extends cqk
{
  public com.tencent.mm.bw.b Buffer;
  public int FOA;
  public dfm FOI;
  public String FOJ;
  public String FOK;
  public int FOL;
  public int FOM;
  public int FON;
  public boolean FOO;
  public String FOP;
  public int FOQ;
  public int FOR;
  public int FOS;
  public String FOT;
  public boolean FOU;
  public String FOV;
  public String FOW;
  public int FOX;
  public dfk FOY;
  public LinkedList<dfh> thF;
  
  public dfj()
  {
    AppMethodBeat.i(152706);
    this.thF = new LinkedList();
    AppMethodBeat.o(152706);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152707);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152707);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.thF);
      if (this.FOI != null)
      {
        paramVarArgs.ln(3, this.FOI.computeSize());
        this.FOI.writeFields(paramVarArgs);
      }
      if (this.FOJ != null) {
        paramVarArgs.d(4, this.FOJ);
      }
      if (this.FOK != null) {
        paramVarArgs.d(5, this.FOK);
      }
      paramVarArgs.aR(6, this.FOL);
      paramVarArgs.aR(9, this.FOM);
      paramVarArgs.aR(10, this.FON);
      paramVarArgs.aR(11, this.FOA);
      paramVarArgs.bl(12, this.FOO);
      if (this.FOP != null) {
        paramVarArgs.d(13, this.FOP);
      }
      paramVarArgs.aR(14, this.FOQ);
      paramVarArgs.aR(15, this.FOR);
      if (this.Buffer != null) {
        paramVarArgs.c(16, this.Buffer);
      }
      paramVarArgs.aR(17, this.FOS);
      if (this.FOT != null) {
        paramVarArgs.d(18, this.FOT);
      }
      paramVarArgs.bl(19, this.FOU);
      if (this.FOV != null) {
        paramVarArgs.d(20, this.FOV);
      }
      if (this.FOW != null) {
        paramVarArgs.d(21, this.FOW);
      }
      paramVarArgs.aR(22, this.FOX);
      if (this.FOY != null)
      {
        paramVarArgs.ln(23, this.FOY.computeSize());
        this.FOY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152707);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1694;
      }
    }
    label1694:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.thF);
      paramInt = i;
      if (this.FOI != null) {
        paramInt = i + f.a.a.a.lm(3, this.FOI.computeSize());
      }
      i = paramInt;
      if (this.FOJ != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FOJ);
      }
      paramInt = i;
      if (this.FOK != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FOK);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.FOL) + f.a.a.b.b.a.bx(9, this.FOM) + f.a.a.b.b.a.bx(10, this.FON) + f.a.a.b.b.a.bx(11, this.FOA) + (f.a.a.b.b.a.fK(12) + 1);
      paramInt = i;
      if (this.FOP != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.FOP);
      }
      i = paramInt + f.a.a.b.b.a.bx(14, this.FOQ) + f.a.a.b.b.a.bx(15, this.FOR);
      paramInt = i;
      if (this.Buffer != null) {
        paramInt = i + f.a.a.b.b.a.b(16, this.Buffer);
      }
      i = paramInt + f.a.a.b.b.a.bx(17, this.FOS);
      paramInt = i;
      if (this.FOT != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.FOT);
      }
      i = paramInt + (f.a.a.b.b.a.fK(19) + 1);
      paramInt = i;
      if (this.FOV != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.FOV);
      }
      i = paramInt;
      if (this.FOW != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.FOW);
      }
      i += f.a.a.b.b.a.bx(22, this.FOX);
      paramInt = i;
      if (this.FOY != null) {
        paramInt = i + f.a.a.a.lm(23, this.FOY.computeSize());
      }
      AppMethodBeat.o(152707);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.thF.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152707);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152707);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dfj localdfj = (dfj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(152707);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152707);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfj.thF.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152707);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfj.FOI = ((dfm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152707);
          return 0;
        case 4: 
          localdfj.FOJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 5: 
          localdfj.FOK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 6: 
          localdfj.FOL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152707);
          return 0;
        case 9: 
          localdfj.FOM = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152707);
          return 0;
        case 10: 
          localdfj.FON = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152707);
          return 0;
        case 11: 
          localdfj.FOA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152707);
          return 0;
        case 12: 
          localdfj.FOO = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(152707);
          return 0;
        case 13: 
          localdfj.FOP = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 14: 
          localdfj.FOQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152707);
          return 0;
        case 15: 
          localdfj.FOR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152707);
          return 0;
        case 16: 
          localdfj.Buffer = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(152707);
          return 0;
        case 17: 
          localdfj.FOS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152707);
          return 0;
        case 18: 
          localdfj.FOT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 19: 
          localdfj.FOU = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(152707);
          return 0;
        case 20: 
          localdfj.FOV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 21: 
          localdfj.FOW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 22: 
          localdfj.FOX = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152707);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dfk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dfk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdfj.FOY = ((dfk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152707);
        return 0;
      }
      AppMethodBeat.o(152707);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfj
 * JD-Core Version:    0.7.0.1
 */