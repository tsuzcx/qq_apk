package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gmq
  extends com.tencent.mm.bx.a
{
  public String Md5;
  public int YQB;
  public int abvI;
  public int abvK;
  public gmn achK;
  public int achZ;
  public boolean acia;
  public String acib;
  public int acic;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153341);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.achK != null)
      {
        paramVarArgs.qD(1, this.achK.computeSize());
        this.achK.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.achZ);
      paramVarArgs.bS(3, this.abvI);
      paramVarArgs.bS(4, this.abvK);
      paramVarArgs.di(5, this.acia);
      paramVarArgs.bS(6, this.YQB);
      if (this.Md5 != null) {
        paramVarArgs.g(7, this.Md5);
      }
      if (this.acib != null) {
        paramVarArgs.g(8, this.acib);
      }
      paramVarArgs.bS(9, this.acic);
      AppMethodBeat.o(153341);
      return 0;
    }
    if (paramInt == 1) {
      if (this.achK == null) {
        break label668;
      }
    }
    label668:
    for (paramInt = i.a.a.a.qC(1, this.achK.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.achZ) + i.a.a.b.b.a.cJ(3, this.abvI) + i.a.a.b.b.a.cJ(4, this.abvK) + (i.a.a.b.b.a.ko(5) + 1) + i.a.a.b.b.a.cJ(6, this.YQB);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.Md5);
      }
      i = paramInt;
      if (this.acib != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.acib);
      }
      paramInt = i.a.a.b.b.a.cJ(9, this.acic);
      AppMethodBeat.o(153341);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153341);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gmq localgmq = (gmq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153341);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            gmn localgmn = new gmn();
            if ((localObject != null) && (localObject.length > 0)) {
              localgmn.parseFrom((byte[])localObject);
            }
            localgmq.achK = localgmn;
            paramInt += 1;
          }
          AppMethodBeat.o(153341);
          return 0;
        case 2: 
          localgmq.achZ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(153341);
          return 0;
        case 3: 
          localgmq.abvI = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(153341);
          return 0;
        case 4: 
          localgmq.abvK = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(153341);
          return 0;
        case 5: 
          localgmq.acia = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(153341);
          return 0;
        case 6: 
          localgmq.YQB = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(153341);
          return 0;
        case 7: 
          localgmq.Md5 = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(153341);
          return 0;
        case 8: 
          localgmq.acib = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(153341);
          return 0;
        }
        localgmq.acic = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(153341);
        return 0;
      }
      AppMethodBeat.o(153341);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gmq
 * JD-Core Version:    0.7.0.1
 */