package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public class ceo
  extends dyy
{
  public int RMr;
  public String Tmg;
  public String Tmh;
  public LinkedList<String> Tmi;
  
  public ceo()
  {
    AppMethodBeat.i(147767);
    this.Tmi = new LinkedList();
    AppMethodBeat.o(147767);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147768);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(147768);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Tmg != null) {
        paramVarArgs.f(2, this.Tmg);
      }
      paramVarArgs.aY(3, this.RMr);
      if (this.Tmh != null) {
        paramVarArgs.f(4, this.Tmh);
      }
      paramVarArgs.e(5, 1, this.Tmi);
      AppMethodBeat.o(147768);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label560;
      }
    }
    label560:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Tmg != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.Tmg);
      }
      i += g.a.a.b.b.a.bM(3, this.RMr);
      paramInt = i;
      if (this.Tmh != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Tmh);
      }
      i = g.a.a.a.c(5, 1, this.Tmi);
      AppMethodBeat.o(147768);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tmi.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(147768);
          throw paramVarArgs;
        }
        AppMethodBeat.o(147768);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ceo localceo = (ceo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147768);
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
            localceo.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(147768);
          return 0;
        case 2: 
          localceo.Tmg = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(147768);
          return 0;
        case 3: 
          localceo.RMr = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(147768);
          return 0;
        case 4: 
          localceo.Tmh = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(147768);
          return 0;
        }
        localceo.Tmi.add(((g.a.a.a.a)localObject).abFh.readString());
        AppMethodBeat.o(147768);
        return 0;
      }
      AppMethodBeat.o(147768);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ceo
 * JD-Core Version:    0.7.0.1
 */