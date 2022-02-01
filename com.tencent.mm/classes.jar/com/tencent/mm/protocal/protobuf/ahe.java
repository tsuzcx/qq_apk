package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ahe
  extends erp
{
  public String IGU;
  public String Zqh;
  public String Zqi;
  public dha Zqj;
  public LinkedList<etl> Zqk;
  public String Zql;
  public String Zqm;
  public int vgN;
  
  public ahe()
  {
    AppMethodBeat.i(32181);
    this.Zqk = new LinkedList();
    AppMethodBeat.o(32181);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32182);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zqj == null)
      {
        paramVarArgs = new b("Not all required fields were included: Loc");
        AppMethodBeat.o(32182);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.IGU != null) {
        paramVarArgs.g(2, this.IGU);
      }
      if (this.Zqh != null) {
        paramVarArgs.g(3, this.Zqh);
      }
      if (this.Zqi != null) {
        paramVarArgs.g(4, this.Zqi);
      }
      if (this.Zqj != null)
      {
        paramVarArgs.qD(5, this.Zqj.computeSize());
        this.Zqj.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.vgN);
      paramVarArgs.e(7, 8, this.Zqk);
      if (this.Zql != null) {
        paramVarArgs.g(8, this.Zql);
      }
      if (this.Zqm != null) {
        paramVarArgs.g(9, this.Zqm);
      }
      AppMethodBeat.o(32182);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label951;
      }
    }
    label951:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IGU != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IGU);
      }
      i = paramInt;
      if (this.Zqh != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Zqh);
      }
      paramInt = i;
      if (this.Zqi != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Zqi);
      }
      i = paramInt;
      if (this.Zqj != null) {
        i = paramInt + i.a.a.a.qC(5, this.Zqj.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(6, this.vgN) + i.a.a.a.c(7, 8, this.Zqk);
      paramInt = i;
      if (this.Zql != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.Zql);
      }
      i = paramInt;
      if (this.Zqm != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.Zqm);
      }
      AppMethodBeat.o(32182);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Zqk.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.Zqj == null)
        {
          paramVarArgs = new b("Not all required fields were included: Loc");
          AppMethodBeat.o(32182);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32182);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ahe localahe = (ahe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32182);
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
            localahe.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32182);
          return 0;
        case 2: 
          localahe.IGU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32182);
          return 0;
        case 3: 
          localahe.Zqh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32182);
          return 0;
        case 4: 
          localahe.Zqi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32182);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dha();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dha)localObject2).parseFrom((byte[])localObject1);
            }
            localahe.Zqj = ((dha)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32182);
          return 0;
        case 6: 
          localahe.vgN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32182);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localahe.Zqk.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32182);
          return 0;
        case 8: 
          localahe.Zql = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32182);
          return 0;
        }
        localahe.Zqm = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(32182);
        return 0;
      }
      AppMethodBeat.o(32182);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahe
 * JD-Core Version:    0.7.0.1
 */