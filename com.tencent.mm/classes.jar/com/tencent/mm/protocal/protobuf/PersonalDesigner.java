package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class PersonalDesigner
  extends com.tencent.mm.bv.a
{
  public int DesignerUin;
  public String HeadUrl;
  public String Name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62578);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.DesignerUin);
      if (this.Name != null) {
        paramVarArgs.e(2, this.Name);
      }
      if (this.HeadUrl != null) {
        paramVarArgs.e(3, this.HeadUrl);
      }
      AppMethodBeat.o(62578);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.DesignerUin) + 0;
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Name);
      }
      i = paramInt;
      if (this.HeadUrl != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.HeadUrl);
      }
      AppMethodBeat.o(62578);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(62578);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      PersonalDesigner localPersonalDesigner = (PersonalDesigner)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(62578);
        return -1;
      case 1: 
        localPersonalDesigner.DesignerUin = locala.CLY.sl();
        AppMethodBeat.o(62578);
        return 0;
      case 2: 
        localPersonalDesigner.Name = locala.CLY.readString();
        AppMethodBeat.o(62578);
        return 0;
      }
      localPersonalDesigner.HeadUrl = locala.CLY.readString();
      AppMethodBeat.o(62578);
      return 0;
    }
    AppMethodBeat.o(62578);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.PersonalDesigner
 * JD-Core Version:    0.7.0.1
 */