package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bqk
  extends com.tencent.mm.bx.a
{
  public bqj ZHW;
  public String ZYt;
  public String ZYu;
  public String ZYv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257740);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZHW != null)
      {
        paramVarArgs.qD(1, this.ZHW.computeSize());
        this.ZHW.writeFields(paramVarArgs);
      }
      if (this.ZYt != null) {
        paramVarArgs.g(2, this.ZYt);
      }
      if (this.ZYu != null) {
        paramVarArgs.g(3, this.ZYu);
      }
      if (this.ZYv != null) {
        paramVarArgs.g(4, this.ZYv);
      }
      AppMethodBeat.o(257740);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZHW == null) {
        break label464;
      }
    }
    label464:
    for (int i = i.a.a.a.qC(1, this.ZHW.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZYt != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZYt);
      }
      i = paramInt;
      if (this.ZYu != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZYu);
      }
      paramInt = i;
      if (this.ZYv != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZYv);
      }
      AppMethodBeat.o(257740);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257740);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bqk localbqk = (bqk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257740);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            bqj localbqj = new bqj();
            if ((localObject != null) && (localObject.length > 0)) {
              localbqj.parseFrom((byte[])localObject);
            }
            localbqk.ZHW = localbqj;
            paramInt += 1;
          }
          AppMethodBeat.o(257740);
          return 0;
        case 2: 
          localbqk.ZYt = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257740);
          return 0;
        case 3: 
          localbqk.ZYu = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257740);
          return 0;
        }
        localbqk.ZYv = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257740);
        return 0;
      }
      AppMethodBeat.o(257740);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqk
 * JD-Core Version:    0.7.0.1
 */