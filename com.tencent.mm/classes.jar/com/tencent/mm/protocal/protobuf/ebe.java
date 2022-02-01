package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ebe
  extends dyy
{
  public String SjB;
  public String Ugd;
  public String Uge;
  public String Ugf;
  public com.tencent.mm.cd.b Ugg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82472);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82472);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.SjB != null) {
        paramVarArgs.f(3, this.SjB);
      }
      if (this.Ugd != null) {
        paramVarArgs.f(4, this.Ugd);
      }
      if (this.Uge != null) {
        paramVarArgs.f(5, this.Uge);
      }
      if (this.Ugf != null) {
        paramVarArgs.f(6, this.Ugf);
      }
      if (this.Ugg != null) {
        paramVarArgs.c(7, this.Ugg);
      }
      AppMethodBeat.o(82472);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label644;
      }
    }
    label644:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SjB != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.SjB);
      }
      i = paramInt;
      if (this.Ugd != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.Ugd);
      }
      paramInt = i;
      if (this.Uge != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Uge);
      }
      i = paramInt;
      if (this.Ugf != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.Ugf);
      }
      paramInt = i;
      if (this.Ugg != null) {
        paramInt = i + g.a.a.b.b.a.b(7, this.Ugg);
      }
      AppMethodBeat.o(82472);
      return paramInt;
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
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(82472);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82472);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ebe localebe = (ebe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        default: 
          AppMethodBeat.o(82472);
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
            localebe.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(82472);
          return 0;
        case 3: 
          localebe.SjB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82472);
          return 0;
        case 4: 
          localebe.Ugd = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82472);
          return 0;
        case 5: 
          localebe.Uge = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82472);
          return 0;
        case 6: 
          localebe.Ugf = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82472);
          return 0;
        }
        localebe.Ugg = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(82472);
        return 0;
      }
      AppMethodBeat.o(82472);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebe
 * JD-Core Version:    0.7.0.1
 */