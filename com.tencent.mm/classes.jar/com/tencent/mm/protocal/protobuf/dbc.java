package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbc
  extends dyy
{
  public String SMW;
  public String SMY;
  public String SNa;
  public String SOL;
  public String SOQ;
  public String TIC;
  public long TID;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231679);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.SOL != null) {
        paramVarArgs.f(2, this.SOL);
      }
      if (this.SMW != null) {
        paramVarArgs.f(3, this.SMW);
      }
      if (this.TIC != null) {
        paramVarArgs.f(4, this.TIC);
      }
      if (this.SMY != null) {
        paramVarArgs.f(5, this.SMY);
      }
      if (this.SNa != null) {
        paramVarArgs.f(6, this.SNa);
      }
      paramVarArgs.bm(7, this.TID);
      if (this.SOQ != null) {
        paramVarArgs.f(8, this.SOQ);
      }
      AppMethodBeat.o(231679);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label700;
      }
    }
    label700:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SOL != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SOL);
      }
      i = paramInt;
      if (this.SMW != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SMW);
      }
      paramInt = i;
      if (this.TIC != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TIC);
      }
      i = paramInt;
      if (this.SMY != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SMY);
      }
      paramInt = i;
      if (this.SNa != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SNa);
      }
      i = paramInt + g.a.a.b.b.a.p(7, this.TID);
      paramInt = i;
      if (this.SOQ != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.SOQ);
      }
      AppMethodBeat.o(231679);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231679);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dbc localdbc = (dbc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231679);
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
            localdbc.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(231679);
          return 0;
        case 2: 
          localdbc.SOL = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(231679);
          return 0;
        case 3: 
          localdbc.SMW = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(231679);
          return 0;
        case 4: 
          localdbc.TIC = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(231679);
          return 0;
        case 5: 
          localdbc.SMY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(231679);
          return 0;
        case 6: 
          localdbc.SNa = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(231679);
          return 0;
        case 7: 
          localdbc.TID = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(231679);
          return 0;
        }
        localdbc.SOQ = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(231679);
        return 0;
      }
      AppMethodBeat.o(231679);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbc
 * JD-Core Version:    0.7.0.1
 */