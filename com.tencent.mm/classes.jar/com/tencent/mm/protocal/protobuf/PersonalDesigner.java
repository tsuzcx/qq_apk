package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class PersonalDesigner
  extends com.tencent.mm.bw.a
{
  public int DesignerUin;
  public String HeadUrl;
  public String Name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104828);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.DesignerUin);
      if (this.Name != null) {
        paramVarArgs.e(2, this.Name);
      }
      if (this.HeadUrl != null) {
        paramVarArgs.e(3, this.HeadUrl);
      }
      AppMethodBeat.o(104828);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.DesignerUin) + 0;
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Name);
      }
      i = paramInt;
      if (this.HeadUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.HeadUrl);
      }
      AppMethodBeat.o(104828);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(104828);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      PersonalDesigner localPersonalDesigner = (PersonalDesigner)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104828);
        return -1;
      case 1: 
        localPersonalDesigner.DesignerUin = locala.UbS.zi();
        AppMethodBeat.o(104828);
        return 0;
      case 2: 
        localPersonalDesigner.Name = locala.UbS.readString();
        AppMethodBeat.o(104828);
        return 0;
      }
      localPersonalDesigner.HeadUrl = locala.UbS.readString();
      AppMethodBeat.o(104828);
      return 0;
    }
    AppMethodBeat.o(104828);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.PersonalDesigner
 * JD-Core Version:    0.7.0.1
 */