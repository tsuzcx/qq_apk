package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class of
  extends dyl
{
  public int CPw;
  public String ProductID;
  public LinkedList<String> RVw;
  public String RVx;
  public double RVy;
  public double RVz;
  
  public of()
  {
    AppMethodBeat.i(124427);
    this.RVw = new LinkedList();
    AppMethodBeat.o(124427);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124428);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ProductID != null) {
        paramVarArgs.f(2, this.ProductID);
      }
      paramVarArgs.e(3, 1, this.RVw);
      paramVarArgs.aY(4, this.CPw);
      if (this.RVx != null) {
        paramVarArgs.f(5, this.RVx);
      }
      paramVarArgs.e(6, this.RVy);
      paramVarArgs.e(7, this.RVz);
      AppMethodBeat.o(124428);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label606;
      }
    }
    label606:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.ProductID);
      }
      i = i + g.a.a.a.c(3, 1, this.RVw) + g.a.a.b.b.a.bM(4, this.CPw);
      paramInt = i;
      if (this.RVx != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RVx);
      }
      i = g.a.a.b.b.a.gL(6);
      int j = g.a.a.b.b.a.gL(7);
      AppMethodBeat.o(124428);
      return paramInt + (i + 8) + (j + 8);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RVw.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124428);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        of localof = (of)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124428);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localof.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(124428);
          return 0;
        case 2: 
          localof.ProductID = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124428);
          return 0;
        case 3: 
          localof.RVw.add(((g.a.a.a.a)localObject).abFh.readString());
          AppMethodBeat.o(124428);
          return 0;
        case 4: 
          localof.CPw = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124428);
          return 0;
        case 5: 
          localof.RVx = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124428);
          return 0;
        case 6: 
          localof.RVy = Double.longBitsToDouble(((g.a.a.a.a)localObject).abFh.AP());
          AppMethodBeat.o(124428);
          return 0;
        }
        localof.RVz = Double.longBitsToDouble(((g.a.a.a.a)localObject).abFh.AP());
        AppMethodBeat.o(124428);
        return 0;
      }
      AppMethodBeat.o(124428);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.of
 * JD-Core Version:    0.7.0.1
 */