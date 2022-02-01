package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dtf
  extends com.tencent.mm.bx.a
{
  public int Mea;
  public LinkedList<FinderObject> ZJp;
  public FinderObject aaYK;
  public String aaYL;
  public bol aaYM;
  public long localId;
  public int scene;
  
  public dtf()
  {
    AppMethodBeat.i(259459);
    this.ZJp = new LinkedList();
    AppMethodBeat.o(259459);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259461);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaYK != null)
      {
        paramVarArgs.qD(1, this.aaYK.computeSize());
        this.aaYK.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ZJp);
      if (this.aaYL != null) {
        paramVarArgs.g(3, this.aaYL);
      }
      paramVarArgs.bS(4, this.scene);
      paramVarArgs.bv(5, this.localId);
      if (this.aaYM != null)
      {
        paramVarArgs.qD(6, this.aaYM.computeSize());
        this.aaYM.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(7, this.Mea);
      AppMethodBeat.o(259461);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaYK == null) {
        break label732;
      }
    }
    label732:
    for (paramInt = i.a.a.a.qC(1, this.aaYK.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.ZJp);
      paramInt = i;
      if (this.aaYL != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.aaYL);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.scene) + i.a.a.b.b.a.q(5, this.localId);
      paramInt = i;
      if (this.aaYM != null) {
        paramInt = i + i.a.a.a.qC(6, this.aaYM.computeSize());
      }
      i = i.a.a.b.b.a.cJ(7, this.Mea);
      AppMethodBeat.o(259461);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZJp.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259461);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dtf localdtf = (dtf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259461);
          return -1;
        case 1: 
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
            localdtf.aaYK = ((FinderObject)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259461);
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
            localdtf.ZJp.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259461);
          return 0;
        case 3: 
          localdtf.aaYL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259461);
          return 0;
        case 4: 
          localdtf.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259461);
          return 0;
        case 5: 
          localdtf.localId = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259461);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bol)localObject2).parseFrom((byte[])localObject1);
            }
            localdtf.aaYM = ((bol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259461);
          return 0;
        }
        localdtf.Mea = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259461);
        return 0;
      }
      AppMethodBeat.o(259461);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtf
 * JD-Core Version:    0.7.0.1
 */