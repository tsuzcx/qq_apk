package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c;
import f.a.a.b;
import java.util.LinkedList;

public final class pc
  extends cqk
{
  public c ByX;
  public long ByZ;
  public long EfB;
  public LinkedList<String> EfC;
  public int EfD;
  public int EfE;
  public String EfF;
  public String EfG;
  public String EfH;
  public boolean EfI;
  public int nWx;
  public String nWy;
  
  public pc()
  {
    AppMethodBeat.i(91377);
    this.EfC = new LinkedList();
    AppMethodBeat.o(91377);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91378);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91378);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.nWx);
      if (this.nWy != null) {
        paramVarArgs.d(3, this.nWy);
      }
      paramVarArgs.aO(4, this.ByZ);
      if (this.ByX != null)
      {
        paramVarArgs.ln(5, this.ByX.computeSize());
        this.ByX.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.EfB);
      paramVarArgs.e(7, 1, this.EfC);
      paramVarArgs.aR(8, this.EfD);
      paramVarArgs.aR(9, this.EfE);
      if (this.EfF != null) {
        paramVarArgs.d(10, this.EfF);
      }
      if (this.EfG != null) {
        paramVarArgs.d(11, this.EfG);
      }
      if (this.EfH != null) {
        paramVarArgs.d(12, this.EfH);
      }
      paramVarArgs.bl(13, this.EfI);
      AppMethodBeat.o(91378);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1082;
      }
    }
    label1082:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt + f.a.a.b.b.a.p(4, this.ByZ);
      paramInt = i;
      if (this.ByX != null) {
        paramInt = i + f.a.a.a.lm(5, this.ByX.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.p(6, this.EfB) + f.a.a.a.c(7, 1, this.EfC) + f.a.a.b.b.a.bx(8, this.EfD) + f.a.a.b.b.a.bx(9, this.EfE);
      paramInt = i;
      if (this.EfF != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.EfF);
      }
      i = paramInt;
      if (this.EfG != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.EfG);
      }
      paramInt = i;
      if (this.EfH != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.EfH);
      }
      i = f.a.a.b.b.a.fK(13);
      AppMethodBeat.o(91378);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EfC.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91378);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91378);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        pc localpc = (pc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91378);
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
            localpc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91378);
          return 0;
        case 2: 
          localpc.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91378);
          return 0;
        case 3: 
          localpc.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91378);
          return 0;
        case 4: 
          localpc.ByZ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91378);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new c();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localpc.ByX = ((c)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91378);
          return 0;
        case 6: 
          localpc.EfB = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91378);
          return 0;
        case 7: 
          localpc.EfC.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(91378);
          return 0;
        case 8: 
          localpc.EfD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91378);
          return 0;
        case 9: 
          localpc.EfE = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91378);
          return 0;
        case 10: 
          localpc.EfF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91378);
          return 0;
        case 11: 
          localpc.EfG = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91378);
          return 0;
        case 12: 
          localpc.EfH = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91378);
          return 0;
        }
        localpc.EfI = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(91378);
        return 0;
      }
      AppMethodBeat.o(91378);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pc
 * JD-Core Version:    0.7.0.1
 */