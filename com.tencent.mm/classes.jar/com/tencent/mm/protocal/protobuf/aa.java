package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aa
  extends buy
{
  public int OpCode;
  public String SSID;
  public String URL;
  public String wkT;
  public String wkU;
  public String wkV;
  public LinkedList<dh> wkW;
  public int wkX;
  public String wkY;
  public int wkZ;
  public String wla;
  
  public aa()
  {
    AppMethodBeat.i(28291);
    this.wkW = new LinkedList();
    AppMethodBeat.o(28291);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28292);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.URL != null) {
        paramVarArgs.e(2, this.URL);
      }
      if (this.SSID != null) {
        paramVarArgs.e(3, this.SSID);
      }
      if (this.wkT != null) {
        paramVarArgs.e(4, this.wkT);
      }
      if (this.wkU != null) {
        paramVarArgs.e(5, this.wkU);
      }
      if (this.wkV != null) {
        paramVarArgs.e(6, this.wkV);
      }
      paramVarArgs.aO(7, this.OpCode);
      paramVarArgs.e(8, 8, this.wkW);
      paramVarArgs.aO(9, this.wkX);
      if (this.wkY != null) {
        paramVarArgs.e(10, this.wkY);
      }
      paramVarArgs.aO(11, this.wkZ);
      if (this.wla != null) {
        paramVarArgs.e(12, this.wla);
      }
      AppMethodBeat.o(28292);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1032;
      }
    }
    label1032:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.URL != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.URL);
      }
      i = paramInt;
      if (this.SSID != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.SSID);
      }
      paramInt = i;
      if (this.wkT != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wkT);
      }
      i = paramInt;
      if (this.wkU != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wkU);
      }
      paramInt = i;
      if (this.wkV != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wkV);
      }
      i = paramInt + e.a.a.b.b.a.bl(7, this.OpCode) + e.a.a.a.c(8, 8, this.wkW) + e.a.a.b.b.a.bl(9, this.wkX);
      paramInt = i;
      if (this.wkY != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.wkY);
      }
      i = paramInt + e.a.a.b.b.a.bl(11, this.wkZ);
      paramInt = i;
      if (this.wla != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.wla);
      }
      AppMethodBeat.o(28292);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wkW.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28292);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aa localaa = (aa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28292);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaa.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28292);
          return 0;
        case 2: 
          localaa.URL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28292);
          return 0;
        case 3: 
          localaa.SSID = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28292);
          return 0;
        case 4: 
          localaa.wkT = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28292);
          return 0;
        case 5: 
          localaa.wkU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28292);
          return 0;
        case 6: 
          localaa.wkV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28292);
          return 0;
        case 7: 
          localaa.OpCode = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28292);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dh();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dh)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaa.wkW.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28292);
          return 0;
        case 9: 
          localaa.wkX = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28292);
          return 0;
        case 10: 
          localaa.wkY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28292);
          return 0;
        case 11: 
          localaa.wkZ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28292);
          return 0;
        }
        localaa.wla = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28292);
        return 0;
      }
      AppMethodBeat.o(28292);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aa
 * JD-Core Version:    0.7.0.1
 */