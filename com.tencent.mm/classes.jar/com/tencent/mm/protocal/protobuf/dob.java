package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dob
  extends dyl
{
  public String CSe;
  public int GIo;
  public String ProductID;
  public String TVo;
  public String TVp;
  public int TVq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91630);
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
      if (this.TVo != null) {
        paramVarArgs.f(3, this.TVo);
      }
      if (this.TVp != null) {
        paramVarArgs.f(4, this.TVp);
      }
      paramVarArgs.aY(5, this.GIo);
      if (this.CSe != null) {
        paramVarArgs.f(7, this.CSe);
      }
      paramVarArgs.aY(8, this.TVq);
      AppMethodBeat.o(91630);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label624;
      }
    }
    label624:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ProductID != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.ProductID);
      }
      i = paramInt;
      if (this.TVo != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TVo);
      }
      paramInt = i;
      if (this.TVp != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TVp);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.GIo);
      paramInt = i;
      if (this.CSe != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.CSe);
      }
      i = g.a.a.b.b.a.bM(8, this.TVq);
      AppMethodBeat.o(91630);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91630);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dob localdob = (dob)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(91630);
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
            localdob.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(91630);
          return 0;
        case 2: 
          localdob.ProductID = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91630);
          return 0;
        case 3: 
          localdob.TVo = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91630);
          return 0;
        case 4: 
          localdob.TVp = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91630);
          return 0;
        case 5: 
          localdob.GIo = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91630);
          return 0;
        case 7: 
          localdob.CSe = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91630);
          return 0;
        }
        localdob.TVq = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91630);
        return 0;
      }
      AppMethodBeat.o(91630);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dob
 * JD-Core Version:    0.7.0.1
 */