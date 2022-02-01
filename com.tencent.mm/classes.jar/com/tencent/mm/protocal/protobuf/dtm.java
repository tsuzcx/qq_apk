package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dtm
  extends dyl
{
  public String OIl;
  public String ONe;
  public String OTh;
  public String fHb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(174534);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.fHb != null) {
        paramVarArgs.f(2, this.fHb);
      }
      if (this.OIl != null) {
        paramVarArgs.f(3, this.OIl);
      }
      if (this.ONe != null) {
        paramVarArgs.f(4, this.ONe);
      }
      if (this.OTh != null) {
        paramVarArgs.f(5, this.OTh);
      }
      AppMethodBeat.o(174534);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label528;
      }
    }
    label528:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fHb != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fHb);
      }
      i = paramInt;
      if (this.OIl != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.OIl);
      }
      paramInt = i;
      if (this.ONe != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.ONe);
      }
      i = paramInt;
      if (this.OTh != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.OTh);
      }
      AppMethodBeat.o(174534);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(174534);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dtm localdtm = (dtm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(174534);
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
            localdtm.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(174534);
          return 0;
        case 2: 
          localdtm.fHb = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(174534);
          return 0;
        case 3: 
          localdtm.OIl = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(174534);
          return 0;
        case 4: 
          localdtm.ONe = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(174534);
          return 0;
        }
        localdtm.OTh = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(174534);
        return 0;
      }
      AppMethodBeat.o(174534);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtm
 * JD-Core Version:    0.7.0.1
 */