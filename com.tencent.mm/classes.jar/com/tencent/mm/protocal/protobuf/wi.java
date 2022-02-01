package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class wi
  extends com.tencent.mm.bx.a
{
  public int Zdd;
  public String Zde;
  public String Zdf;
  public String Zdg;
  public int Zdh;
  public String Zdi;
  public wg Zdj;
  public String Zdk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113967);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Zdd);
      if (this.Zde != null) {
        paramVarArgs.g(2, this.Zde);
      }
      if (this.Zdf != null) {
        paramVarArgs.g(3, this.Zdf);
      }
      if (this.Zdg != null) {
        paramVarArgs.g(4, this.Zdg);
      }
      paramVarArgs.bS(5, this.Zdh);
      if (this.Zdi != null) {
        paramVarArgs.g(6, this.Zdi);
      }
      if (this.Zdj != null)
      {
        paramVarArgs.qD(7, this.Zdj.computeSize());
        this.Zdj.writeFields(paramVarArgs);
      }
      if (this.Zdk != null) {
        paramVarArgs.g(8, this.Zdk);
      }
      AppMethodBeat.o(113967);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.Zdd) + 0;
      paramInt = i;
      if (this.Zde != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Zde);
      }
      i = paramInt;
      if (this.Zdf != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Zdf);
      }
      paramInt = i;
      if (this.Zdg != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Zdg);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.Zdh);
      paramInt = i;
      if (this.Zdi != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.Zdi);
      }
      i = paramInt;
      if (this.Zdj != null) {
        i = paramInt + i.a.a.a.qC(7, this.Zdj.computeSize());
      }
      paramInt = i;
      if (this.Zdk != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.Zdk);
      }
      AppMethodBeat.o(113967);
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
      AppMethodBeat.o(113967);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      wi localwi = (wi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(113967);
        return -1;
      case 1: 
        localwi.Zdd = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(113967);
        return 0;
      case 2: 
        localwi.Zde = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(113967);
        return 0;
      case 3: 
        localwi.Zdf = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(113967);
        return 0;
      case 4: 
        localwi.Zdg = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(113967);
        return 0;
      case 5: 
        localwi.Zdh = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(113967);
        return 0;
      case 6: 
        localwi.Zdi = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(113967);
        return 0;
      case 7: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          wg localwg = new wg();
          if ((localObject != null) && (localObject.length > 0)) {
            localwg.parseFrom((byte[])localObject);
          }
          localwi.Zdj = localwg;
          paramInt += 1;
        }
        AppMethodBeat.o(113967);
        return 0;
      }
      localwi.Zdk = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(113967);
      return 0;
    }
    AppMethodBeat.o(113967);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wi
 * JD-Core Version:    0.7.0.1
 */