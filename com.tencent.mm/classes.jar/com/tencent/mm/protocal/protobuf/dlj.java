package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class dlj
  extends erp
{
  public b Zsu;
  public int aaRx;
  public int aaRy;
  public String id;
  public int oUj;
  public int offset;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259231);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.scene);
      if (this.id != null) {
        paramVarArgs.g(3, this.id);
      }
      if (this.Zsu != null) {
        paramVarArgs.d(4, this.Zsu);
      }
      paramVarArgs.bS(5, this.oUj);
      paramVarArgs.bS(6, this.offset);
      paramVarArgs.bS(7, this.aaRx);
      paramVarArgs.bS(8, this.aaRy);
      AppMethodBeat.o(259231);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label636;
      }
    }
    label636:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.scene);
      paramInt = i;
      if (this.id != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.id);
      }
      i = paramInt;
      if (this.Zsu != null) {
        i = paramInt + i.a.a.b.b.a.c(4, this.Zsu);
      }
      paramInt = i.a.a.b.b.a.cJ(5, this.oUj);
      int j = i.a.a.b.b.a.cJ(6, this.offset);
      int k = i.a.a.b.b.a.cJ(7, this.aaRx);
      int m = i.a.a.b.b.a.cJ(8, this.aaRy);
      AppMethodBeat.o(259231);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259231);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dlj localdlj = (dlj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259231);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localdlj.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(259231);
          return 0;
        case 2: 
          localdlj.scene = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259231);
          return 0;
        case 3: 
          localdlj.id = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259231);
          return 0;
        case 4: 
          localdlj.Zsu = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(259231);
          return 0;
        case 5: 
          localdlj.oUj = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259231);
          return 0;
        case 6: 
          localdlj.offset = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259231);
          return 0;
        case 7: 
          localdlj.aaRx = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259231);
          return 0;
        }
        localdlj.aaRy = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259231);
        return 0;
      }
      AppMethodBeat.o(259231);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlj
 * JD-Core Version:    0.7.0.1
 */