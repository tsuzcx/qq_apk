package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dec
  extends dyl
{
  public int DgI;
  public String GGC;
  public String OmF;
  public int Oms;
  public String TLJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91558);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.DgI);
      paramVarArgs.aY(3, this.Oms);
      if (this.GGC != null) {
        paramVarArgs.f(4, this.GGC);
      }
      if (this.TLJ != null) {
        paramVarArgs.f(5, this.TLJ);
      }
      if (this.OmF != null) {
        paramVarArgs.f(100, this.OmF);
      }
      AppMethodBeat.o(91558);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label576;
      }
    }
    label576:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.DgI) + g.a.a.b.b.a.bM(3, this.Oms);
      paramInt = i;
      if (this.GGC != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.GGC);
      }
      i = paramInt;
      if (this.TLJ != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.TLJ);
      }
      paramInt = i;
      if (this.OmF != null) {
        paramInt = i + g.a.a.b.b.a.g(100, this.OmF);
      }
      AppMethodBeat.o(91558);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91558);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dec localdec = (dec)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91558);
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
            localdec.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(91558);
          return 0;
        case 2: 
          localdec.DgI = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91558);
          return 0;
        case 3: 
          localdec.Oms = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91558);
          return 0;
        case 4: 
          localdec.GGC = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91558);
          return 0;
        case 5: 
          localdec.TLJ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91558);
          return 0;
        }
        localdec.OmF = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91558);
        return 0;
      }
      AppMethodBeat.o(91558);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dec
 * JD-Core Version:    0.7.0.1
 */