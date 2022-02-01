package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bux
  extends com.tencent.mm.bx.a
{
  public awt AtP;
  public b ZRe;
  public String aacq;
  public String aacr;
  public long aacs;
  public int actionType;
  public String appId;
  public String link;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259155);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aacq != null) {
        paramVarArgs.g(1, this.aacq);
      }
      paramVarArgs.bS(2, this.actionType);
      if (this.link != null) {
        paramVarArgs.g(3, this.link);
      }
      if (this.appId != null) {
        paramVarArgs.g(4, this.appId);
      }
      if (this.ZRe != null) {
        paramVarArgs.d(5, this.ZRe);
      }
      if (this.aacr != null) {
        paramVarArgs.g(6, this.aacr);
      }
      if (this.AtP != null)
      {
        paramVarArgs.qD(7, this.AtP.computeSize());
        this.AtP.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(8, this.aacs);
      AppMethodBeat.o(259155);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aacq == null) {
        break label680;
      }
    }
    label680:
    for (paramInt = i.a.a.b.b.a.h(1, this.aacq) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.actionType);
      paramInt = i;
      if (this.link != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.link);
      }
      i = paramInt;
      if (this.appId != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.appId);
      }
      paramInt = i;
      if (this.ZRe != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.ZRe);
      }
      i = paramInt;
      if (this.aacr != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.aacr);
      }
      paramInt = i;
      if (this.AtP != null) {
        paramInt = i + i.a.a.a.qC(7, this.AtP.computeSize());
      }
      i = i.a.a.b.b.a.q(8, this.aacs);
      AppMethodBeat.o(259155);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259155);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bux localbux = (bux)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259155);
          return -1;
        case 1: 
          localbux.aacq = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259155);
          return 0;
        case 2: 
          localbux.actionType = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259155);
          return 0;
        case 3: 
          localbux.link = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259155);
          return 0;
        case 4: 
          localbux.appId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259155);
          return 0;
        case 5: 
          localbux.ZRe = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(259155);
          return 0;
        case 6: 
          localbux.aacr = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259155);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            awt localawt = new awt();
            if ((localObject != null) && (localObject.length > 0)) {
              localawt.parseFrom((byte[])localObject);
            }
            localbux.AtP = localawt;
            paramInt += 1;
          }
          AppMethodBeat.o(259155);
          return 0;
        }
        localbux.aacs = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(259155);
        return 0;
      }
      AppMethodBeat.o(259155);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bux
 * JD-Core Version:    0.7.0.1
 */