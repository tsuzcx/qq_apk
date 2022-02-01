package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class anj
  extends com.tencent.mm.bx.a
{
  public String IGG;
  public String IHo;
  public String ProductID;
  public int Zue;
  public ani akjS;
  public String akjU;
  public String akjV;
  public String akjW;
  public String hAP;
  public int hjP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104770);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.akjS == null)
      {
        paramVarArgs = new b("Not all required fields were included: BannerImg");
        AppMethodBeat.o(104770);
        throw paramVarArgs;
      }
      if (this.akjS != null)
      {
        paramVarArgs.qD(1, this.akjS.computeSize());
        this.akjS.writeFields(paramVarArgs);
      }
      if (this.hAP != null) {
        paramVarArgs.g(2, this.hAP);
      }
      if (this.akjU != null) {
        paramVarArgs.g(3, this.akjU);
      }
      paramVarArgs.bS(4, this.hjP);
      if (this.akjV != null) {
        paramVarArgs.g(5, this.akjV);
      }
      paramVarArgs.bS(6, this.Zue);
      if (this.IHo != null) {
        paramVarArgs.g(7, this.IHo);
      }
      if (this.IGG != null) {
        paramVarArgs.g(8, this.IGG);
      }
      if (this.ProductID != null) {
        paramVarArgs.g(9, this.ProductID);
      }
      if (this.akjW != null) {
        paramVarArgs.g(10, this.akjW);
      }
      AppMethodBeat.o(104770);
      return 0;
    }
    if (paramInt == 1) {
      if (this.akjS == null) {
        break label852;
      }
    }
    label852:
    for (int i = i.a.a.a.qC(1, this.akjS.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hAP != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hAP);
      }
      i = paramInt;
      if (this.akjU != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.akjU);
      }
      i += i.a.a.b.b.a.cJ(4, this.hjP);
      paramInt = i;
      if (this.akjV != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.akjV);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.Zue);
      paramInt = i;
      if (this.IHo != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.IHo);
      }
      i = paramInt;
      if (this.IGG != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.IGG);
      }
      paramInt = i;
      if (this.ProductID != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.ProductID);
      }
      i = paramInt;
      if (this.akjW != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.akjW);
      }
      AppMethodBeat.o(104770);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.akjS == null)
        {
          paramVarArgs = new b("Not all required fields were included: BannerImg");
          AppMethodBeat.o(104770);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104770);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        anj localanj = (anj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104770);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ani localani = new ani();
            if ((localObject != null) && (localObject.length > 0)) {
              localani.parseFrom((byte[])localObject);
            }
            localanj.akjS = localani;
            paramInt += 1;
          }
          AppMethodBeat.o(104770);
          return 0;
        case 2: 
          localanj.hAP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104770);
          return 0;
        case 3: 
          localanj.akjU = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104770);
          return 0;
        case 4: 
          localanj.hjP = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(104770);
          return 0;
        case 5: 
          localanj.akjV = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104770);
          return 0;
        case 6: 
          localanj.Zue = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(104770);
          return 0;
        case 7: 
          localanj.IHo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104770);
          return 0;
        case 8: 
          localanj.IGG = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104770);
          return 0;
        case 9: 
          localanj.ProductID = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104770);
          return 0;
        }
        localanj.akjW = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(104770);
        return 0;
      }
      AppMethodBeat.o(104770);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anj
 * JD-Core Version:    0.7.0.1
 */