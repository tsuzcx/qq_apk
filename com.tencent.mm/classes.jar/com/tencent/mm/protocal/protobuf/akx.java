package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class akx
  extends dyl
{
  public int CPw;
  public String ProductID;
  public String SvE;
  public int VHS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104782);
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
      if (this.SvE != null) {
        paramVarArgs.f(3, this.SvE);
      }
      paramVarArgs.aY(4, this.VHS);
      paramVarArgs.aY(5, this.CPw);
      AppMethodBeat.o(104782);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label500;
      }
    }
    label500:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ProductID != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.ProductID);
      }
      i = paramInt;
      if (this.SvE != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SvE);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.VHS);
      int j = g.a.a.b.b.a.bM(5, this.CPw);
      AppMethodBeat.o(104782);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(104782);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        akx localakx = (akx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104782);
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
            localakx.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(104782);
          return 0;
        case 2: 
          localakx.ProductID = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104782);
          return 0;
        case 3: 
          localakx.SvE = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104782);
          return 0;
        case 4: 
          localakx.VHS = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(104782);
          return 0;
        }
        localakx.CPw = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(104782);
        return 0;
      }
      AppMethodBeat.o(104782);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akx
 * JD-Core Version:    0.7.0.1
 */