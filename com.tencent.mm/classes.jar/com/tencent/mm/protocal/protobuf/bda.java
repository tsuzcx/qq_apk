package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bda
  extends com.tencent.mm.cd.a
{
  public int SOi;
  public LinkedList<bda> SOj;
  public bda SOk;
  public int SOl;
  public int SOm;
  public String ugl;
  
  public bda()
  {
    AppMethodBeat.i(230648);
    this.SOj = new LinkedList();
    AppMethodBeat.o(230648);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230649);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SOi);
      if (this.ugl != null) {
        paramVarArgs.f(2, this.ugl);
      }
      paramVarArgs.e(3, 8, this.SOj);
      if (this.SOk != null)
      {
        paramVarArgs.oE(4, this.SOk.computeSize());
        this.SOk.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.SOl);
      paramVarArgs.aY(6, this.SOm);
      AppMethodBeat.o(230649);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.SOi) + 0;
      paramInt = i;
      if (this.ugl != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.ugl);
      }
      i = paramInt + g.a.a.a.c(3, 8, this.SOj);
      paramInt = i;
      if (this.SOk != null) {
        paramInt = i + g.a.a.a.oD(4, this.SOk.computeSize());
      }
      i = g.a.a.b.b.a.bM(5, this.SOl);
      int j = g.a.a.b.b.a.bM(6, this.SOm);
      AppMethodBeat.o(230649);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SOj.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(230649);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      bda localbda1 = (bda)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      bda localbda2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(230649);
        return -1;
      case 1: 
        localbda1.SOi = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(230649);
        return 0;
      case 2: 
        localbda1.ugl = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(230649);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localbda2 = new bda();
          if ((localObject != null) && (localObject.length > 0)) {
            localbda2.parseFrom((byte[])localObject);
          }
          localbda1.SOj.add(localbda2);
          paramInt += 1;
        }
        AppMethodBeat.o(230649);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localbda2 = new bda();
          if ((localObject != null) && (localObject.length > 0)) {
            localbda2.parseFrom((byte[])localObject);
          }
          localbda1.SOk = localbda2;
          paramInt += 1;
        }
        AppMethodBeat.o(230649);
        return 0;
      case 5: 
        localbda1.SOl = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(230649);
        return 0;
      }
      localbda1.SOm = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(230649);
      return 0;
    }
    AppMethodBeat.o(230649);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bda
 * JD-Core Version:    0.7.0.1
 */