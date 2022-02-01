package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class doc
  extends dyy
{
  public String TVr;
  public String TVs;
  public String TVt;
  public String TVu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91631);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91631);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.TVr != null) {
        paramVarArgs.f(2, this.TVr);
      }
      if (this.TVs != null) {
        paramVarArgs.f(3, this.TVs);
      }
      if (this.TVt != null) {
        paramVarArgs.f(4, this.TVt);
      }
      if (this.TVu != null) {
        paramVarArgs.f(5, this.TVu);
      }
      AppMethodBeat.o(91631);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label576;
      }
    }
    label576:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TVr != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TVr);
      }
      i = paramInt;
      if (this.TVs != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TVs);
      }
      paramInt = i;
      if (this.TVt != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TVt);
      }
      i = paramInt;
      if (this.TVu != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.TVu);
      }
      AppMethodBeat.o(91631);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91631);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91631);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        doc localdoc = (doc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91631);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            localdoc.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(91631);
          return 0;
        case 2: 
          localdoc.TVr = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91631);
          return 0;
        case 3: 
          localdoc.TVs = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91631);
          return 0;
        case 4: 
          localdoc.TVt = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91631);
          return 0;
        }
        localdoc.TVu = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91631);
        return 0;
      }
      AppMethodBeat.o(91631);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doc
 * JD-Core Version:    0.7.0.1
 */