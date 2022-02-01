package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class drj
  extends cqk
{
  public LinkedList<drd> DVd;
  public long Exg;
  public int FMY;
  public long FOh;
  public int FYW;
  public int FYX;
  public int FYY;
  public LinkedList<drd> FYZ;
  public com.tencent.mm.bw.b Fwg;
  public int tIQ;
  public int tIW;
  public int tIX;
  public int tJb;
  
  public drj()
  {
    AppMethodBeat.i(125499);
    this.DVd = new LinkedList();
    this.FYZ = new LinkedList();
    AppMethodBeat.o(125499);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125500);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125500);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.FOh);
      paramVarArgs.aO(3, this.Exg);
      paramVarArgs.e(4, 8, this.DVd);
      paramVarArgs.aR(5, this.FMY);
      paramVarArgs.aR(6, this.tIW);
      paramVarArgs.aR(7, this.tIX);
      paramVarArgs.aR(8, this.tIQ);
      paramVarArgs.aR(9, this.tJb);
      paramVarArgs.aR(10, this.FYW);
      paramVarArgs.aR(11, this.FYX);
      if (this.Fwg != null) {
        paramVarArgs.c(12, this.Fwg);
      }
      paramVarArgs.aR(13, this.FYY);
      paramVarArgs.e(14, 8, this.FYZ);
      AppMethodBeat.o(125500);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1142;
      }
    }
    label1142:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.FOh) + f.a.a.b.b.a.p(3, this.Exg) + f.a.a.a.c(4, 8, this.DVd) + f.a.a.b.b.a.bx(5, this.FMY) + f.a.a.b.b.a.bx(6, this.tIW) + f.a.a.b.b.a.bx(7, this.tIX) + f.a.a.b.b.a.bx(8, this.tIQ) + f.a.a.b.b.a.bx(9, this.tJb) + f.a.a.b.b.a.bx(10, this.FYW) + f.a.a.b.b.a.bx(11, this.FYX);
      paramInt = i;
      if (this.Fwg != null) {
        paramInt = i + f.a.a.b.b.a.b(12, this.Fwg);
      }
      i = f.a.a.b.b.a.bx(13, this.FYY);
      int j = f.a.a.a.c(14, 8, this.FYZ);
      AppMethodBeat.o(125500);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DVd.clear();
        this.FYZ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125500);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125500);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        drj localdrj = (drj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125500);
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
            localdrj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125500);
          return 0;
        case 2: 
          localdrj.FOh = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125500);
          return 0;
        case 3: 
          localdrj.Exg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125500);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new drd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((drd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdrj.DVd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125500);
          return 0;
        case 5: 
          localdrj.FMY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125500);
          return 0;
        case 6: 
          localdrj.tIW = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125500);
          return 0;
        case 7: 
          localdrj.tIX = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125500);
          return 0;
        case 8: 
          localdrj.tIQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125500);
          return 0;
        case 9: 
          localdrj.tJb = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125500);
          return 0;
        case 10: 
          localdrj.FYW = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125500);
          return 0;
        case 11: 
          localdrj.FYX = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125500);
          return 0;
        case 12: 
          localdrj.Fwg = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(125500);
          return 0;
        case 13: 
          localdrj.FYY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125500);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new drd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((drd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdrj.FYZ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125500);
        return 0;
      }
      AppMethodBeat.o(125500);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drj
 * JD-Core Version:    0.7.0.1
 */