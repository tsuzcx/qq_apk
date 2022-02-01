package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dvy
  extends cpx
{
  public LinkedList<Integer> Gdo;
  public String djj;
  public int id;
  public String query;
  
  public dvy()
  {
    AppMethodBeat.i(121118);
    this.Gdo = new LinkedList();
    AppMethodBeat.o(121118);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121119);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.djj != null) {
        paramVarArgs.d(2, this.djj);
      }
      paramVarArgs.aR(3, this.id);
      paramVarArgs.e(4, 2, this.Gdo);
      if (this.query != null) {
        paramVarArgs.d(5, this.query);
      }
      AppMethodBeat.o(121119);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label533;
      }
    }
    label533:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.djj != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.djj);
      }
      i = i + f.a.a.b.b.a.bx(3, this.id) + f.a.a.a.c(4, 2, this.Gdo);
      paramInt = i;
      if (this.query != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.query);
      }
      AppMethodBeat.o(121119);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gdo.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(121119);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dvy localdvy = (dvy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(121119);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdvy.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(121119);
          return 0;
        case 2: 
          localdvy.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(121119);
          return 0;
        case 3: 
          localdvy.id = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(121119);
          return 0;
        case 4: 
          localdvy.Gdo.add(Integer.valueOf(((f.a.a.a.a)localObject1).LVo.xF()));
          AppMethodBeat.o(121119);
          return 0;
        }
        localdvy.query = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(121119);
        return 0;
      }
      AppMethodBeat.o(121119);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvy
 * JD-Core Version:    0.7.0.1
 */