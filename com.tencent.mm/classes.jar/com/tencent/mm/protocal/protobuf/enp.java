package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class enp
  extends com.tencent.mm.bx.a
{
  public String YVF;
  public int Zwh;
  public String Zxq;
  public String Zxr;
  public int abrD;
  public String abrE;
  public ens abrF;
  public String abrH;
  public nk absd;
  public ddb abse;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259883);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.absd != null)
      {
        paramVarArgs.qD(1, this.absd.computeSize());
        this.absd.writeFields(paramVarArgs);
      }
      if (this.abse != null)
      {
        paramVarArgs.qD(2, this.abse.computeSize());
        this.abse.writeFields(paramVarArgs);
      }
      if (this.YVF != null) {
        paramVarArgs.g(3, this.YVF);
      }
      if (this.Zxr != null) {
        paramVarArgs.g(4, this.Zxr);
      }
      if (this.Zxq != null) {
        paramVarArgs.g(5, this.Zxq);
      }
      if (this.abrE != null) {
        paramVarArgs.g(6, this.abrE);
      }
      paramVarArgs.bS(7, this.abrD);
      if (this.abrF != null)
      {
        paramVarArgs.qD(8, this.abrF.computeSize());
        this.abrF.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(9, this.Zwh);
      if (this.abrH != null) {
        paramVarArgs.g(10, this.abrH);
      }
      AppMethodBeat.o(259883);
      return 0;
    }
    if (paramInt == 1) {
      if (this.absd == null) {
        break label948;
      }
    }
    label948:
    for (int i = i.a.a.a.qC(1, this.absd.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abse != null) {
        paramInt = i + i.a.a.a.qC(2, this.abse.computeSize());
      }
      i = paramInt;
      if (this.YVF != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YVF);
      }
      paramInt = i;
      if (this.Zxr != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Zxr);
      }
      i = paramInt;
      if (this.Zxq != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.Zxq);
      }
      paramInt = i;
      if (this.abrE != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abrE);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.abrD);
      paramInt = i;
      if (this.abrF != null) {
        paramInt = i + i.a.a.a.qC(8, this.abrF.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.Zwh);
      paramInt = i;
      if (this.abrH != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.abrH);
      }
      AppMethodBeat.o(259883);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259883);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        enp localenp = (enp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259883);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new nk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((nk)localObject2).parseFrom((byte[])localObject1);
            }
            localenp.absd = ((nk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259883);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ddb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ddb)localObject2).parseFrom((byte[])localObject1);
            }
            localenp.abse = ((ddb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259883);
          return 0;
        case 3: 
          localenp.YVF = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259883);
          return 0;
        case 4: 
          localenp.Zxr = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259883);
          return 0;
        case 5: 
          localenp.Zxq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259883);
          return 0;
        case 6: 
          localenp.abrE = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259883);
          return 0;
        case 7: 
          localenp.abrD = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259883);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ens();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ens)localObject2).parseFrom((byte[])localObject1);
            }
            localenp.abrF = ((ens)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259883);
          return 0;
        case 9: 
          localenp.Zwh = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259883);
          return 0;
        }
        localenp.abrH = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(259883);
        return 0;
      }
      AppMethodBeat.o(259883);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.enp
 * JD-Core Version:    0.7.0.1
 */