package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bsk
  extends esc
{
  public int BeA;
  public String YYd;
  public b ZEQ;
  public fes aaae;
  public int aaai;
  public int aaaj;
  public eer aaak;
  public int aaal;
  public FinderContact contact;
  public LinkedList<FinderObject> object;
  
  public bsk()
  {
    AppMethodBeat.i(259835);
    this.object = new LinkedList();
    AppMethodBeat.o(259835);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259845);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.ZEQ != null) {
        paramVarArgs.d(3, this.ZEQ);
      }
      paramVarArgs.bS(4, this.BeA);
      if (this.aaae != null)
      {
        paramVarArgs.qD(5, this.aaae.computeSize());
        this.aaae.writeFields(paramVarArgs);
      }
      if (this.contact != null)
      {
        paramVarArgs.qD(6, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      if (this.YYd != null) {
        paramVarArgs.g(7, this.YYd);
      }
      paramVarArgs.bS(8, this.aaai);
      paramVarArgs.bS(9, this.aaaj);
      if (this.aaak != null)
      {
        paramVarArgs.qD(10, this.aaak.computeSize());
        this.aaak.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(12, this.aaal);
      AppMethodBeat.o(259845);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1112;
      }
    }
    label1112:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.ZEQ != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.ZEQ);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.BeA);
      paramInt = i;
      if (this.aaae != null) {
        paramInt = i + i.a.a.a.qC(5, this.aaae.computeSize());
      }
      i = paramInt;
      if (this.contact != null) {
        i = paramInt + i.a.a.a.qC(6, this.contact.computeSize());
      }
      paramInt = i;
      if (this.YYd != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.YYd);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.aaai) + i.a.a.b.b.a.cJ(9, this.aaaj);
      paramInt = i;
      if (this.aaak != null) {
        paramInt = i + i.a.a.a.qC(10, this.aaak.computeSize());
      }
      i = i.a.a.b.b.a.cJ(12, this.aaal);
      AppMethodBeat.o(259845);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259845);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bsk localbsk = (bsk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 11: 
        default: 
          AppMethodBeat.o(259845);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localbsk.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259845);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localbsk.object.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259845);
          return 0;
        case 3: 
          localbsk.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259845);
          return 0;
        case 4: 
          localbsk.BeA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259845);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fes();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fes)localObject2).parseFrom((byte[])localObject1);
            }
            localbsk.aaae = ((fes)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259845);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderContact();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderContact)localObject2).parseFrom((byte[])localObject1);
            }
            localbsk.contact = ((FinderContact)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259845);
          return 0;
        case 7: 
          localbsk.YYd = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259845);
          return 0;
        case 8: 
          localbsk.aaai = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259845);
          return 0;
        case 9: 
          localbsk.aaaj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259845);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eer();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eer)localObject2).parseFrom((byte[])localObject1);
            }
            localbsk.aaak = ((eer)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259845);
          return 0;
        }
        localbsk.aaal = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259845);
        return 0;
      }
      AppMethodBeat.o(259845);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsk
 * JD-Core Version:    0.7.0.1
 */