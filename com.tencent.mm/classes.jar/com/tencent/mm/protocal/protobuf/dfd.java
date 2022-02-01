package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dfd
  extends com.tencent.mm.bx.a
{
  public boolean aaKW;
  public eol aaKX;
  public int jump_type;
  public String rGU;
  public String right_button_wording;
  public String title;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91528);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.jump_type);
      paramVarArgs.di(2, this.aaKW);
      if (this.wording != null) {
        paramVarArgs.g(3, this.wording);
      }
      if (this.rGU != null) {
        paramVarArgs.g(4, this.rGU);
      }
      if (this.right_button_wording != null) {
        paramVarArgs.g(5, this.right_button_wording);
      }
      if (this.aaKX != null)
      {
        paramVarArgs.qD(6, this.aaKX.computeSize());
        this.aaKX.writeFields(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.g(7, this.title);
      }
      AppMethodBeat.o(91528);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.jump_type) + 0 + (i.a.a.b.b.a.ko(2) + 1);
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wording);
      }
      i = paramInt;
      if (this.rGU != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.rGU);
      }
      paramInt = i;
      if (this.right_button_wording != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.right_button_wording);
      }
      i = paramInt;
      if (this.aaKX != null) {
        i = paramInt + i.a.a.a.qC(6, this.aaKX.computeSize());
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.title);
      }
      AppMethodBeat.o(91528);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91528);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      dfd localdfd = (dfd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91528);
        return -1;
      case 1: 
        localdfd.jump_type = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91528);
        return 0;
      case 2: 
        localdfd.aaKW = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(91528);
        return 0;
      case 3: 
        localdfd.wording = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91528);
        return 0;
      case 4: 
        localdfd.rGU = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91528);
        return 0;
      case 5: 
        localdfd.right_button_wording = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91528);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eol localeol = new eol();
          if ((localObject != null) && (localObject.length > 0)) {
            localeol.parseFrom((byte[])localObject);
          }
          localdfd.aaKX = localeol;
          paramInt += 1;
        }
        AppMethodBeat.o(91528);
        return 0;
      }
      localdfd.title = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(91528);
      return 0;
    }
    AppMethodBeat.o(91528);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfd
 * JD-Core Version:    0.7.0.1
 */