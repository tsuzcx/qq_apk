package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ffn
  extends com.tencent.mm.bx.a
{
  public long abFt;
  public long abFu;
  public long abFv;
  public LinkedList<fed> abFw;
  public String abFx;
  public String hOK;
  public String hQR;
  public String ooc;
  
  public ffn()
  {
    AppMethodBeat.i(122548);
    this.abFt = 0L;
    this.abFu = 0L;
    this.abFv = 0L;
    this.abFw = new LinkedList();
    AppMethodBeat.o(122548);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122549);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hQR != null) {
        paramVarArgs.g(1, this.hQR);
      }
      paramVarArgs.bv(2, this.abFt);
      paramVarArgs.bv(3, this.abFu);
      paramVarArgs.bv(4, this.abFv);
      paramVarArgs.e(5, 8, this.abFw);
      if (this.hOK != null) {
        paramVarArgs.g(6, this.hOK);
      }
      if (this.ooc != null) {
        paramVarArgs.g(7, this.ooc);
      }
      if (this.abFx != null) {
        paramVarArgs.g(8, this.abFx);
      }
      AppMethodBeat.o(122549);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hQR == null) {
        break label644;
      }
    }
    label644:
    for (paramInt = i.a.a.b.b.a.h(1, this.hQR) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.abFt) + i.a.a.b.b.a.q(3, this.abFu) + i.a.a.b.b.a.q(4, this.abFv) + i.a.a.a.c(5, 8, this.abFw);
      paramInt = i;
      if (this.hOK != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.hOK);
      }
      i = paramInt;
      if (this.ooc != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ooc);
      }
      paramInt = i;
      if (this.abFx != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.abFx);
      }
      AppMethodBeat.o(122549);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abFw.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(122549);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ffn localffn = (ffn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122549);
          return -1;
        case 1: 
          localffn.hQR = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(122549);
          return 0;
        case 2: 
          localffn.abFt = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(122549);
          return 0;
        case 3: 
          localffn.abFu = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(122549);
          return 0;
        case 4: 
          localffn.abFv = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(122549);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fed localfed = new fed();
            if ((localObject != null) && (localObject.length > 0)) {
              localfed.parseFrom((byte[])localObject);
            }
            localffn.abFw.add(localfed);
            paramInt += 1;
          }
          AppMethodBeat.o(122549);
          return 0;
        case 6: 
          localffn.hOK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(122549);
          return 0;
        case 7: 
          localffn.ooc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(122549);
          return 0;
        }
        localffn.abFx = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(122549);
        return 0;
      }
      AppMethodBeat.o(122549);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffn
 * JD-Core Version:    0.7.0.1
 */