package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bky
  extends com.tencent.mm.bx.a
{
  public String ZTZ;
  public String ZUa;
  public String ZUb;
  public String ZUc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259462);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZTZ != null) {
        paramVarArgs.g(1, this.ZTZ);
      }
      if (this.ZUa != null) {
        paramVarArgs.g(2, this.ZUa);
      }
      if (this.ZUb != null) {
        paramVarArgs.g(3, this.ZUb);
      }
      if (this.ZUc != null) {
        paramVarArgs.g(4, this.ZUc);
      }
      AppMethodBeat.o(259462);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZTZ == null) {
        break label390;
      }
    }
    label390:
    for (int i = i.a.a.b.b.a.h(1, this.ZTZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZUa != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZUa);
      }
      i = paramInt;
      if (this.ZUb != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZUb);
      }
      paramInt = i;
      if (this.ZUc != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZUc);
      }
      AppMethodBeat.o(259462);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259462);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bky localbky = (bky)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259462);
          return -1;
        case 1: 
          localbky.ZTZ = locala.ajGk.readString();
          AppMethodBeat.o(259462);
          return 0;
        case 2: 
          localbky.ZUa = locala.ajGk.readString();
          AppMethodBeat.o(259462);
          return 0;
        case 3: 
          localbky.ZUb = locala.ajGk.readString();
          AppMethodBeat.o(259462);
          return 0;
        }
        localbky.ZUc = locala.ajGk.readString();
        AppMethodBeat.o(259462);
        return 0;
      }
      AppMethodBeat.o(259462);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bky
 * JD-Core Version:    0.7.0.1
 */