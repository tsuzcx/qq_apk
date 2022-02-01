package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dsf
  extends com.tencent.mm.bx.a
{
  public boo LWI;
  public String ZTw;
  public String aaXV;
  public String aaYa;
  public int aaYb;
  public String rDl;
  public String xmo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259904);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaXV != null) {
        paramVarArgs.g(1, this.aaXV);
      }
      if (this.ZTw != null) {
        paramVarArgs.g(2, this.ZTw);
      }
      if (this.rDl != null) {
        paramVarArgs.g(3, this.rDl);
      }
      if (this.xmo != null) {
        paramVarArgs.g(4, this.xmo);
      }
      if (this.aaYa != null) {
        paramVarArgs.g(5, this.aaYa);
      }
      paramVarArgs.bS(6, this.aaYb);
      if (this.LWI != null)
      {
        paramVarArgs.qD(7, this.LWI.computeSize());
        this.LWI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259904);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaXV == null) {
        break label632;
      }
    }
    label632:
    for (int i = i.a.a.b.b.a.h(1, this.aaXV) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZTw != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZTw);
      }
      i = paramInt;
      if (this.rDl != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.rDl);
      }
      paramInt = i;
      if (this.xmo != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.xmo);
      }
      i = paramInt;
      if (this.aaYa != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaYa);
      }
      i += i.a.a.b.b.a.cJ(6, this.aaYb);
      paramInt = i;
      if (this.LWI != null) {
        paramInt = i + i.a.a.a.qC(7, this.LWI.computeSize());
      }
      AppMethodBeat.o(259904);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259904);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dsf localdsf = (dsf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259904);
          return -1;
        case 1: 
          localdsf.aaXV = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259904);
          return 0;
        case 2: 
          localdsf.ZTw = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259904);
          return 0;
        case 3: 
          localdsf.rDl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259904);
          return 0;
        case 4: 
          localdsf.xmo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259904);
          return 0;
        case 5: 
          localdsf.aaYa = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259904);
          return 0;
        case 6: 
          localdsf.aaYb = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259904);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          boo localboo = new boo();
          if ((localObject != null) && (localObject.length > 0)) {
            localboo.parseFrom((byte[])localObject);
          }
          localdsf.LWI = localboo;
          paramInt += 1;
        }
        AppMethodBeat.o(259904);
        return 0;
      }
      AppMethodBeat.o(259904);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsf
 * JD-Core Version:    0.7.0.1
 */