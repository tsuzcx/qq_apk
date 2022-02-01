package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bha
  extends com.tencent.mm.bx.a
{
  public String Idh;
  public String Idi;
  public String ZQA;
  public int ZQB;
  public cbr ZQy;
  public int ZQz;
  public String xlr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257928);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZQy != null)
      {
        paramVarArgs.qD(1, this.ZQy.computeSize());
        this.ZQy.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.ZQz);
      if (this.Idh != null) {
        paramVarArgs.g(3, this.Idh);
      }
      if (this.Idi != null) {
        paramVarArgs.g(4, this.Idi);
      }
      if (this.ZQA != null) {
        paramVarArgs.g(5, this.ZQA);
      }
      paramVarArgs.bS(6, this.ZQB);
      if (this.xlr != null) {
        paramVarArgs.g(7, this.xlr);
      }
      AppMethodBeat.o(257928);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZQy == null) {
        break label616;
      }
    }
    label616:
    for (paramInt = i.a.a.a.qC(1, this.ZQy.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ZQz);
      paramInt = i;
      if (this.Idh != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.Idh);
      }
      i = paramInt;
      if (this.Idi != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.Idi);
      }
      paramInt = i;
      if (this.ZQA != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZQA);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.ZQB);
      paramInt = i;
      if (this.xlr != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.xlr);
      }
      AppMethodBeat.o(257928);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257928);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bha localbha = (bha)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257928);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            cbr localcbr = new cbr();
            if ((localObject != null) && (localObject.length > 0)) {
              localcbr.parseFrom((byte[])localObject);
            }
            localbha.ZQy = localcbr;
            paramInt += 1;
          }
          AppMethodBeat.o(257928);
          return 0;
        case 2: 
          localbha.ZQz = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257928);
          return 0;
        case 3: 
          localbha.Idh = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257928);
          return 0;
        case 4: 
          localbha.Idi = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257928);
          return 0;
        case 5: 
          localbha.ZQA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257928);
          return 0;
        case 6: 
          localbha.ZQB = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257928);
          return 0;
        }
        localbha.xlr = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257928);
        return 0;
      }
      AppMethodBeat.o(257928);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bha
 * JD-Core Version:    0.7.0.1
 */