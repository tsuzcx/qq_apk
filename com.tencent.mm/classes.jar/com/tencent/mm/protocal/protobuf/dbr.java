package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dbr
  extends cqk
{
  public czx FKZ;
  public int Fkc;
  public LinkedList<czx> Fkd;
  public long Id;
  public String hkN;
  public int ndI;
  public int vTH;
  public int vTI;
  
  public dbr()
  {
    AppMethodBeat.i(125831);
    this.Fkd = new LinkedList();
    AppMethodBeat.o(125831);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125832);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125832);
        throw paramVarArgs;
      }
      if (this.FKZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: BufferUrl");
        AppMethodBeat.o(125832);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.vTI);
      paramVarArgs.aR(3, this.vTH);
      if (this.hkN != null) {
        paramVarArgs.d(4, this.hkN);
      }
      if (this.FKZ != null)
      {
        paramVarArgs.ln(5, this.FKZ.computeSize());
        this.FKZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.Fkc);
      paramVarArgs.e(7, 8, this.Fkd);
      paramVarArgs.aO(8, this.Id);
      paramVarArgs.aR(9, this.ndI);
      AppMethodBeat.o(125832);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label994;
      }
    }
    label994:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.vTI) + f.a.a.b.b.a.bx(3, this.vTH);
      paramInt = i;
      if (this.hkN != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hkN);
      }
      i = paramInt;
      if (this.FKZ != null) {
        i = paramInt + f.a.a.a.lm(5, this.FKZ.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(6, this.Fkc);
      int j = f.a.a.a.c(7, 8, this.Fkd);
      int k = f.a.a.b.b.a.p(8, this.Id);
      int m = f.a.a.b.b.a.bx(9, this.ndI);
      AppMethodBeat.o(125832);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Fkd.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125832);
          throw paramVarArgs;
        }
        if (this.FKZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: BufferUrl");
          AppMethodBeat.o(125832);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125832);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dbr localdbr = (dbr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125832);
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
            localdbr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125832);
          return 0;
        case 2: 
          localdbr.vTI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125832);
          return 0;
        case 3: 
          localdbr.vTH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125832);
          return 0;
        case 4: 
          localdbr.hkN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125832);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new czx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((czx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbr.FKZ = ((czx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125832);
          return 0;
        case 6: 
          localdbr.Fkc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125832);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new czx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((czx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbr.Fkd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125832);
          return 0;
        case 8: 
          localdbr.Id = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125832);
          return 0;
        }
        localdbr.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125832);
        return 0;
      }
      AppMethodBeat.o(125832);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbr
 * JD-Core Version:    0.7.0.1
 */