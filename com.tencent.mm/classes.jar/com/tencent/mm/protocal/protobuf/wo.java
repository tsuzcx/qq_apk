package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class wo
  extends dyl
{
  public int SiP;
  public String SiQ;
  public int SiR;
  public b Sio;
  public int amount;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(250495);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.SiP);
      paramVarArgs.aY(3, this.amount);
      if (this.SiQ != null) {
        paramVarArgs.f(4, this.SiQ);
      }
      if (this.url != null) {
        paramVarArgs.f(5, this.url);
      }
      paramVarArgs.aY(6, this.SiR);
      if (this.Sio != null) {
        paramVarArgs.c(7, this.Sio);
      }
      AppMethodBeat.o(250495);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label604;
      }
    }
    label604:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.SiP) + g.a.a.b.b.a.bM(3, this.amount);
      paramInt = i;
      if (this.SiQ != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SiQ);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.url);
      }
      i += g.a.a.b.b.a.bM(6, this.SiR);
      paramInt = i;
      if (this.Sio != null) {
        paramInt = i + g.a.a.b.b.a.b(7, this.Sio);
      }
      AppMethodBeat.o(250495);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(250495);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        wo localwo = (wo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(250495);
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
            localwo.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(250495);
          return 0;
        case 2: 
          localwo.SiP = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(250495);
          return 0;
        case 3: 
          localwo.amount = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(250495);
          return 0;
        case 4: 
          localwo.SiQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(250495);
          return 0;
        case 5: 
          localwo.url = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(250495);
          return 0;
        case 6: 
          localwo.SiR = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(250495);
          return 0;
        }
        localwo.Sio = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(250495);
        return 0;
      }
      AppMethodBeat.o(250495);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wo
 * JD-Core Version:    0.7.0.1
 */