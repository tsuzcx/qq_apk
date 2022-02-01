package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eck
  extends com.tencent.mm.bx.a
{
  public String VcU;
  public String VcV;
  public String VsH;
  public eoe abib;
  public String desc;
  public int jump_type;
  public String nQG;
  public String name;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72542);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.g(1, this.name);
      }
      if (this.title != null) {
        paramVarArgs.g(2, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.g(3, this.desc);
      }
      if (this.nQG != null) {
        paramVarArgs.g(4, this.nQG);
      }
      paramVarArgs.bS(5, this.jump_type);
      if (this.VsH != null) {
        paramVarArgs.g(6, this.VsH);
      }
      if (this.VcU != null) {
        paramVarArgs.g(7, this.VcU);
      }
      if (this.VcV != null) {
        paramVarArgs.g(8, this.VcV);
      }
      if (this.abib != null)
      {
        paramVarArgs.qD(9, this.abib.computeSize());
        this.abib.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72542);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label756;
      }
    }
    label756:
    for (int i = i.a.a.b.b.a.h(1, this.name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.title);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.desc);
      }
      paramInt = i;
      if (this.nQG != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.nQG);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.jump_type);
      paramInt = i;
      if (this.VsH != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.VsH);
      }
      i = paramInt;
      if (this.VcU != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.VcU);
      }
      paramInt = i;
      if (this.VcV != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.VcV);
      }
      i = paramInt;
      if (this.abib != null) {
        i = paramInt + i.a.a.a.qC(9, this.abib.computeSize());
      }
      AppMethodBeat.o(72542);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72542);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eck localeck = (eck)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72542);
          return -1;
        case 1: 
          localeck.name = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 2: 
          localeck.title = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 3: 
          localeck.desc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 4: 
          localeck.nQG = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 5: 
          localeck.jump_type = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72542);
          return 0;
        case 6: 
          localeck.VsH = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 7: 
          localeck.VcU = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 8: 
          localeck.VcV = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72542);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eoe localeoe = new eoe();
          if ((localObject != null) && (localObject.length > 0)) {
            localeoe.parseFrom((byte[])localObject);
          }
          localeck.abib = localeoe;
          paramInt += 1;
        }
        AppMethodBeat.o(72542);
        return 0;
      }
      AppMethodBeat.o(72542);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eck
 * JD-Core Version:    0.7.0.1
 */