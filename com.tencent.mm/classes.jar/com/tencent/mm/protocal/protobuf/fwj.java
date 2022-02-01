package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fwj
  extends erp
{
  public int MFe;
  public String ProductID;
  public gol abUh;
  public int abUi;
  public int abUj;
  public String abUk;
  public String ablY;
  public String ablZ;
  public int abma;
  public String abmb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91722);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abUh == null)
      {
        paramVarArgs = new b("Not all required fields were included: Receipt");
        AppMethodBeat.o(91722);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abUh != null)
      {
        paramVarArgs.qD(2, this.abUh.computeSize());
        this.abUh.writeFields(paramVarArgs);
      }
      if (this.ProductID != null) {
        paramVarArgs.g(3, this.ProductID);
      }
      paramVarArgs.bS(4, this.abUi);
      paramVarArgs.bS(5, this.MFe);
      if (this.ablY != null) {
        paramVarArgs.g(6, this.ablY);
      }
      if (this.ablZ != null) {
        paramVarArgs.g(7, this.ablZ);
      }
      if (this.abmb != null) {
        paramVarArgs.g(8, this.abmb);
      }
      paramVarArgs.bS(9, this.abUj);
      if (this.abUk != null) {
        paramVarArgs.g(10, this.abUk);
      }
      paramVarArgs.bS(11, this.abma);
      AppMethodBeat.o(91722);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label950;
      }
    }
    label950:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abUh != null) {
        paramInt = i + i.a.a.a.qC(2, this.abUh.computeSize());
      }
      i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ProductID);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.abUi) + i.a.a.b.b.a.cJ(5, this.MFe);
      paramInt = i;
      if (this.ablY != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ablY);
      }
      i = paramInt;
      if (this.ablZ != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ablZ);
      }
      paramInt = i;
      if (this.abmb != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.abmb);
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.abUj);
      paramInt = i;
      if (this.abUk != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.abUk);
      }
      i = i.a.a.b.b.a.cJ(11, this.abma);
      AppMethodBeat.o(91722);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abUh == null)
        {
          paramVarArgs = new b("Not all required fields were included: Receipt");
          AppMethodBeat.o(91722);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91722);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fwj localfwj = (fwj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91722);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localfwj.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91722);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localfwj.abUh = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91722);
          return 0;
        case 3: 
          localfwj.ProductID = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91722);
          return 0;
        case 4: 
          localfwj.abUi = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91722);
          return 0;
        case 5: 
          localfwj.MFe = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91722);
          return 0;
        case 6: 
          localfwj.ablY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91722);
          return 0;
        case 7: 
          localfwj.ablZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91722);
          return 0;
        case 8: 
          localfwj.abmb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91722);
          return 0;
        case 9: 
          localfwj.abUj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91722);
          return 0;
        case 10: 
          localfwj.abUk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91722);
          return 0;
        }
        localfwj.abma = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91722);
        return 0;
      }
      AppMethodBeat.o(91722);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fwj
 * JD-Core Version:    0.7.0.1
 */