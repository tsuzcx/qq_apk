import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import com.tencent.device.qfind.BluetoothLeService;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

public class acaj
  extends BluetoothGattCallback
{
  public acaj(BluetoothLeService paramBluetoothLeService) {}
  
  public void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DeviceBLE_EX", 2, "onCharacteristicChanged uuid=" + paramBluetoothGattCharacteristic.getUuid());
    }
    acao localacao = BluetoothLeService.a(this.a, paramBluetoothGatt);
    if ((localacao != null) && (paramBluetoothGattCharacteristic == localacao.jdField_b_of_type_AndroidBluetoothBluetoothGattCharacteristic))
    {
      BluetoothLeService.a(this.a, "com.tencent.device.ble.ACTION_DATA_AVAILABLE", 0, paramBluetoothGatt, localacao.jdField_b_of_type_AndroidBluetoothBluetoothGattCharacteristic, false);
      if (QLog.isColorLevel()) {
        QLog.i("DeviceBLE_EX", 2, "btvalue=" + bhml.a(paramBluetoothGattCharacteristic.getValue()));
      }
    }
  }
  
  public void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DeviceBLE_EX", 2, "onCharacteristicWrite status=" + paramInt + ",uuid=" + paramBluetoothGattCharacteristic.getUuid());
    }
    acao localacao = BluetoothLeService.a(this.a, paramBluetoothGatt);
    if (paramInt == 0)
    {
      if ((localacao != null) && (paramBluetoothGattCharacteristic == localacao.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic))
      {
        if (localacao.jdField_a_of_type_ArrayOfByte != null) {
          BluetoothLeService.a(this.a, localacao);
        }
      }
      else {
        return;
      }
      BluetoothLeService.a(this.a, "com.tencent.device.ble.ACTION_DATA_WRITE_RST", paramInt, paramBluetoothGatt, null, true);
      return;
    }
    BluetoothLeService.a(this.a, "com.tencent.device.ble.ACTION_DATA_WRITE_RST", paramInt, paramBluetoothGatt, null, false);
  }
  
  public void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    acao localacao = BluetoothLeService.a(this.a, paramBluetoothGatt);
    if (localacao == null) {
      if (QLog.isColorLevel()) {
        QLog.i("DeviceBLE_EX", 2, "onConnectionStateChange but no gattInfo newState=" + paramInt2);
      }
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("DeviceBLE_EX", 2, "onConnectionStateChange status=" + paramInt1 + " newState=" + paramInt2);
      }
      if ((paramInt1 != 0) || (paramInt2 == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("DeviceBLE_EX", 2, "Disconnected from GATT server. status:" + paramInt1);
        }
        paramInt2 = localacao.jdField_a_of_type_Int;
        this.a.b(localacao.jdField_a_of_type_Int);
        BluetoothLeService.a(this.a, "com.tencent.device.ble.ACTION_GATT_DISCONNECTED", paramInt1, paramInt2);
        return;
      }
      if (paramInt2 != 2) {
        continue;
      }
      localacao.jdField_b_of_type_Int = 2;
      BluetoothLeService.a(this.a, "com.tencent.device.ble.ACTION_GATT_CONNECTED", paramInt1, paramBluetoothGatt, null, false);
      try
      {
        Thread.sleep(200L);
        label186:
        boolean bool = localacao.jdField_a_of_type_AndroidBluetoothBluetoothGatt.discoverServices();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("DeviceBLE_EX", 2, "Connected to GATT server.");
        QLog.i("DeviceBLE_EX", 2, "Attempting to start service discovery:" + bool);
        return;
      }
      catch (Throwable paramBluetoothGatt)
      {
        break label186;
      }
    }
  }
  
  public void onDescriptorWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DeviceBLE_EX", 2, "onDescriptorWrite uuid=" + paramBluetoothGattDescriptor.getUuid() + ",status=" + paramInt + ",value=" + paramBluetoothGattDescriptor.getValue());
    }
    BluetoothLeService.a(this.a, paramBluetoothGatt);
    if (paramInt == 0)
    {
      BluetoothLeService.a(this.a, "com.tencent.device.ble.ACTION_GATT_SERVICES_DISCOVERED", paramInt, paramBluetoothGatt, null, false);
      return;
    }
    BluetoothLeService.a(this.a, "com.tencent.device.ble.ACTION_GATT_SET_NOTIFICATION_FAILED", paramInt, paramBluetoothGatt, null, false);
  }
  
  public void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    acao localacao;
    if (paramInt == 0)
    {
      localacao = BluetoothLeService.a(this.a, paramBluetoothGatt);
      if (localacao == null) {
        if (QLog.isColorLevel()) {
          QLog.w("DeviceBLE_EX", 2, "onServicesDiscovered gattInfo is null");
        }
      }
    }
    for (;;)
    {
      return;
      localacao.jdField_a_of_type_AndroidBluetoothBluetoothGattService = localacao.jdField_a_of_type_AndroidBluetoothBluetoothGatt.getService(UUID.fromString(BluetoothLeService.a));
      if (localacao.jdField_a_of_type_AndroidBluetoothBluetoothGattService != null)
      {
        localacao.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic = localacao.jdField_a_of_type_AndroidBluetoothBluetoothGattService.getCharacteristic(UUID.fromString(BluetoothLeService.e));
        if (localacao.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic == null) {
          localacao.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic = localacao.jdField_a_of_type_AndroidBluetoothBluetoothGattService.getCharacteristic(UUID.fromString(BluetoothLeService.b));
        }
        localacao.jdField_b_of_type_AndroidBluetoothBluetoothGattCharacteristic = localacao.jdField_a_of_type_AndroidBluetoothBluetoothGattService.getCharacteristic(UUID.fromString(BluetoothLeService.f));
        if (localacao.jdField_b_of_type_AndroidBluetoothBluetoothGattCharacteristic == null) {
          localacao.jdField_b_of_type_AndroidBluetoothBluetoothGattCharacteristic = localacao.jdField_a_of_type_AndroidBluetoothBluetoothGattService.getCharacteristic(UUID.fromString(BluetoothLeService.c));
        }
        localacao.c = localacao.jdField_a_of_type_AndroidBluetoothBluetoothGattService.getCharacteristic(UUID.fromString(BluetoothLeService.g));
        if (localacao.c == null) {
          localacao.c = localacao.jdField_a_of_type_AndroidBluetoothBluetoothGattService.getCharacteristic(UUID.fromString(BluetoothLeService.d));
        }
        if ((localacao.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic == null) || ((localacao.jdField_a_of_type_AndroidBluetoothBluetoothGattCharacteristic.getProperties() & 0x8) == 0) || (localacao.jdField_b_of_type_AndroidBluetoothBluetoothGattCharacteristic == null) || ((localacao.jdField_b_of_type_AndroidBluetoothBluetoothGattCharacteristic.getProperties() & 0x20) == 0) || (localacao.c == null) || ((localacao.c.getProperties() & 0x2) == 0))
        {
          BluetoothLeService.a(this.a, "com.tencent.device.ble.ACTION_GATT_NOT_QQ", paramInt, paramBluetoothGatt, null, false);
          return;
        }
      }
      try
      {
        Thread.sleep(1000L);
        label258:
        this.a.a(paramBluetoothGatt, localacao.jdField_b_of_type_AndroidBluetoothBluetoothGattCharacteristic, true);
        return;
        BluetoothLeService.a(this.a, "com.tencent.device.ble.ACTION_GATT_NOT_QQ", paramInt, paramBluetoothGatt, null, false);
        return;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("DeviceBLE_EX", 2, "onServicesDiscovered received: " + paramInt);
        return;
      }
      catch (Throwable localThrowable)
      {
        break label258;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acaj
 * JD-Core Version:    0.7.0.1
 */