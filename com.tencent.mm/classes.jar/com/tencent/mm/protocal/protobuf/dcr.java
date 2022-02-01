package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dcr
  extends com.tencent.mm.bx.a
{
  public String UserName;
  public String YNN;
  public String Zpa;
  public int aaIA;
  public etl aaIz;
  public int yth;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155423);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaIz == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(155423);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.yth);
      if (this.aaIz != null)
      {
        paramVarArgs.qD(2, this.aaIz.computeSize());
        this.aaIz.writeFields(paramVarArgs);
      }
      if (this.YNN != null) {
        paramVarArgs.g(3, this.YNN);
      }
      if (this.Zpa != null) {
        paramVarArgs.g(4, this.Zpa);
      }
      if (this.UserName != null) {
        paramVarArgs.g(5, this.UserName);
      }
      paramVarArgs.bS(6, this.aaIA);
      AppMethodBeat.o(155423);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.yth) + 0;
      paramInt = i;
      if (this.aaIz != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaIz.computeSize());
      }
      i = paramInt;
      if (this.YNN != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YNN);
      }
      paramInt = i;
      if (this.Zpa != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Zpa);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.UserName);
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.aaIA);
      AppMethodBeat.o(155423);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.aaIz == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(155423);
        throw paramVarArgs;
      }
      AppMethodBeat.o(155423);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      dcr localdcr = (dcr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(155423);
        return -1;
      case 1: 
        localdcr.yth = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(155423);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          etl localetl = new etl();
          if ((localObject != null) && (localObject.length > 0)) {
            localetl.dh((byte[])localObject);
          }
          localdcr.aaIz = localetl;
          paramInt += 1;
        }
        AppMethodBeat.o(155423);
        return 0;
      case 3: 
        localdcr.YNN = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(155423);
        return 0;
      case 4: 
        localdcr.Zpa = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(155423);
        return 0;
      case 5: 
        localdcr.UserName = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(155423);
        return 0;
      }
      localdcr.aaIA = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(155423);
      return 0;
    }
    AppMethodBeat.o(155423);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcr
 * JD-Core Version:    0.7.0.1
 */